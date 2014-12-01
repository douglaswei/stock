#!/usr/bin/python
#coding=utf-8
#****************************************************************#
# ScriptName: crawler/spiders/bestgo_spider.py
# Create Date: 2014-09-27 22:02
# Modify Date: 2014-09-27 22:02
#***************************************************************#

import scrapy
from scrapy.contrib.spiders import CrawlSpider, Rule
from scrapy.contrib.linkextractors.sgml import SgmlLinkExtractor
from scrapy.selector import Selector

from crawler.items import StockItem
from crawler.local_settings import DESIRED_DATE_STR

from datetime import date
from datetime import timedelta
import json
import urlparse

class BestgoSpider(CrawlSpider):
    name = "stock_bestgo"
    allowed_domains = ["bestgo.com",]
    start_urls = []

    for page_id in range(1,32):
        url = "http://www.bestgo.com/fund/SH/%s/1,%d.html" % \
                (DESIRED_DATE_STR, page_id)
        start_urls.append(url)
        url = "http://www.bestgo.com/hd/SH/%s/1,%d.html" % \
                (DESIRED_DATE_STR, page_id)
        start_urls.append(url)

    allowed_url = 'http://www.bestgo.com/fund/SH/' + DESIRED_DATE_STR + '/1.\d+\.html'
    allowed_hd_url = 'http://www.bestgo.com/hd/SH/' + DESIRED_DATE_STR + '/1.\d+\.html'
    rules = [
        Rule(SgmlLinkExtractor(allow=(allowed_url,)), follow = True, callback="parse_item"),
        Rule(SgmlLinkExtractor(allow=(allowed_hd_url,)), follow = True, callback="parse_hd_item"),
    ]

    def extract_item(self, response):
        hxs = Selector(response)
        stocks = hxs.xpath('//div[@class="grid-view"]/table/tbody/tr')
        self.log(str(len(stocks)))
        for stock in stocks:
            stock_items = stock.xpath('./td')
            if len(stock_items) < 16:
                continue
            item = StockItem()
            code = "sh" + stock_items[0].xpath('./a/span/text()')[0].extract()
            records = []
            records.append( stock_items[2].xpath('./text()')[0].extract())
            for idx in range(3, 17):
                records.append(stock_items[idx].xpath('./text()')[0].extract())
            yield [code, records]

    def parse_item(self, response):
        for [code, records] in self.extract_item(response):
            item = StockItem()
            item['code'] = code
            item['records'] = records
            item['cate'] = 'fund'
            yield item

    def parse_hd_item(self, response):
        for [code, records] in self.extract_item(response):
            item = StockItem()
            item['code'] = code
            item['records'] = records
            item['cate'] = 'hd'
            yield item


