#!/usr/bin/python
#coding=utf-8
#****************************************************************#
# ScriptName: crawler/spiders/ifeng_spider.py
# Create Date: 2014-09-27 22:02
# Modify Date: 2014-09-27 22:02
#***************************************************************#

import scrapy
from scrapy.contrib.spiders import CrawlSpider, Rule
from scrapy.contrib.linkextractors.sgml import SgmlLinkExtractor
from scrapy.selector import Selector

from crawler.items import StockItem

from datetime import date
from datetime import timedelta
import json
import urlparse

class IfengSpider(CrawlSpider):
    name = "stock_ifeng"
    szIndexUrl = ["http://api.finance.ifeng.com/index.php/akdaily/?code=sh000001&tpye=fq",
            "http://api.finance.ifeng.com/index.php/akdaily/?code=sz399001&tpye=fq"]
    allowed_domains = ["bestgo.com",
        "api.finance.ifeng.com",
        "app.finance.ifeng.com",
        ]
    start_urls = [
    ]

    day_str = []
    for day_span in range(1, 19, 5):
        day_str.append((date.today() - timedelta(days = day_span)).strftime('%Y%m%d'))
    for page_id in range(1, 32):
        for day in day_str:
            url = "http://www.bestgo.com/fund/SH/%s/1,%d.html" % (day, page_id)
            start_urls.append(url)
            url = "http://www.bestgo.com/fund/%s/1,%d.html" % (day, page_id)
            start_urls.append(url)
    for idx in [1, 2, 3, 5, 7]:
        url = "http://app.finance.ifeng.com/list/all_stock_cate.php?s=%d" % idx
        start_urls.append(url)

    rules = [
        Rule(SgmlLinkExtractor(allow=(r'http://www.bestgo.com/fund/.*\d+/1.\d+\.html')), follow = True, callback="parse_item"),
        Rule(SgmlLinkExtractor(allow=(r'http://app.finance.ifeng.com/list/stock_cate.php\?c=\d+$')), follow = True, callback="parse_cate"),
    ]

    def parse_item(self, response):
        for url in self.szIndexUrl:
            yield scrapy.Request(url, self.parse_api)
        hxs = Selector(response)
        stocks = hxs.xpath('//div[@class="grid-view"]/table/tbody/tr')
        self.log(str(len(stocks)))
        for stock in stocks:
            stock_id = stock.xpath('./td/a/span/text()')
            if len(stock_id) < 1:
                continue
            stock_code = 'sz'
            if 'SH' in response.url:
                stock_code = 'sh'
            stock_code = stock_code + stock_id[0].extract()
            self.log('[' + response.url + "]:[" + stock_code + ']',
                    level=scrapy.log.DEBUG)
            api_url = "http://api.finance.ifeng.com/index.php/akdaily/?code=%s&tpye=fq" % (stock_code)
            yield scrapy.Request(api_url, self.parse_api)

    def parse_api(self, response):
        stock_code = None
        params = response.url.split('?')[-1].split('&')
        for param in params:
            [k, v] = param.split('=')
            if k == 'code':
                stock_code = v

        if stock_code is None:
            self.log("no stock_id found in [" + response.url+ "]", scrapy.log.CRITICAL)


        data = json.loads(response.body)
        records = data["record"]
        for record in records:
            self.log("stock history:" + stock_code + ":" + ",".join(record))
        item = StockItem()
        item["code"] = stock_code
        item["records"] = records
        item['cate'] = 'ifeng'
        return item

    def parse_cate(self, response):
        stock_cate = None
        params = response.url.split('?')[-1].split('&')
        for param in params:
            [k, v] = param.split('=')
            if k == 'c':
                stock_cate = v
        stock_code_list = []
        hxs = Selector(response)
        stock_codes = hxs.xpath('//table/tr/td[1]/a').extract()
        self.log("[cate_code]" + str(len(stock_codes)))
        for stock_code in stock_codes:
            items = stock_code.split('/')
            if len(items) < 6:
                continue
            code = items[6]
            self.log(code)
            stock_code_list.append(code)
        item = StockItem()
        item['code'] = stock_cate
        item['records'] = stock_code_list
        item['cate'] = "cate"
        return item

