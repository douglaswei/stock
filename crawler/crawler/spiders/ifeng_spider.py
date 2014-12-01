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
    szIndexUrl = "http://api.finance.ifeng.com/index.php/akdaily/?code=sh000001&tpye=fq"
    allowed_domains = ["bestgo.com",
        "api.finance.ifeng.com",]
    start_urls = [
    ]

    day_str = []
    for day_span in range(1, 20):
        day_str.append((date.today() - timedelta(days = day_span)).strftime('%Y%m%d'))
    for page_id in range(1, 32, 3):
        for day in day_str:
            url = "http://www.bestgo.com/fund/SH/%s/1,%d.html" % (day, page_id)
            start_urls.append(url)

    rules = [
        Rule(SgmlLinkExtractor(allow=(r'http://www.bestgo.com/fund/SH/\d+/1.\d+\.html')), follow = True, callback="parse_item"),
    ]

    def parse_item(self, response):
        yield scrapy.Request(self.szIndexUrl, self.parse_api)
        hxs = Selector(response)
        stocks = hxs.xpath('//div[@class="grid-view"]/table/tbody/tr')
        self.log(str(len(stocks)))
        for stock in stocks:
            stock_id = stock.xpath('./td/a/span/text()')
            if len(stock_id) < 1:
                continue
            self.log('[' + response.url + "]:[" + stock_id[0].extract() + ']',
                    level=scrapy.log.DEBUG)
            api_url = "http://api.finance.ifeng.com/index.php/akdaily/?code=sh%s&tpye=fq" % (stock_id[0].extract())
            yield scrapy.Request(api_url, self.parse_api)

    def parse_api(self, response):
#        self.log("[api_url]:[" + response.url + '],[content]:[' + response.body + ']'
#                , scrapy.log.DEBUG)
        stock_code = None
        params = response.url.split('?')[-1].split('&')
        for param in params:
            [k, v] = param.split('=')
            if k == 'code':
                stock_code = v

        if stock_code is None:
            self.log("no stock_id found in [" + response.url+ "]", scrapy.log.CRITICAL)

        self.log(str(response.request.meta))

        data = json.loads(response.body)
        records = data["record"]
        for record in records:
            self.log(stock_code + ":" + ",".join(record))
        item = StockItem()
        item["code"] = stock_code
        item["records"] = records
        item['cate'] = 'ifeng'
        return item
