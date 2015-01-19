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
from crawler.local_settings import DESIRED_DATES

from datetime import date
from datetime import timedelta
import json
import urlparse
import re

class BestgoSpider(CrawlSpider):
    name = "stock_bestgo"
    allowed_domains = ["bestgo.com",]
    start_urls = []

    for date in DESIRED_DATES:
        url = "http://www.bestgo.com/fund/SH/%s/1,1.html" % (date)
        start_urls.append(url)
        url = "http://www.bestgo.com/hd/SH/%s/1,1.html" % (date)
        start_urls.append(url)
        url = "http://www.bestgo.com/fund/%s/1,1.html" % (date)
        start_urls.append(url)
        url = "http://www.bestgo.com/hd/%s/1,1.html" % (date)
        start_urls.append(url)

    allowed_url = 'http://www.bestgo.com/fund/.*\d{6}/1.\d+\.html'
    allowed_hd_url = 'http://www.bestgo.com/hd/.*\d{6}/1.\d+\.html'
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
            district = 'sz'
            if "SH" in response.url:
                district = 'sh'
            code = district + stock_items[0].xpath('./a/span/text()')[0].extract()
            records = []
            records.append( stock_items[2].xpath('./text()')[0].extract())
            for idx in range(2, 17):
                item = stock_items[idx].xpath('./text()')[0].extract()
                records.append(item)
            yield [code, records]

    def parse_item(self, response):
        date = self.getDate(response.url)
        for [code, records] in self.extract_item(response):
            item = StockItem()
            item['code'] = code
            item['records'] = records
            item['channel'] = 'fund'
            item['date'] = date
            yield item

    def parse_hd_item(self, response):
        date = self.getDate(response.url)
        for [code, records] in self.extract_item(response):
            item = StockItem()
            item['code'] = code
            item['records'] = records
            item['channel'] = 'hd'
            item['date'] = date
            yield item


    def getDate(self, url):
        m = re.search(r'(\d{8})', url)
        if not m:
            self.log('date no found in url')
        date = m.group(0)
        return date
