#!/usr/bin/python
#coding=utf-8
#****************************************************************#
# ScriptName: crawler/spiders/kuqing_spider.py
# Create Date: 2014-06-18 22:02
# Modify Date: 2014-06-18 22:02
#***************************************************************#

from scrapy.contrib.spiders import CrawlSpider, Rule
from scrapy.contrib.linkextractors.sgml import SgmlLinkExtractor
from scrapy.selector import Selector

from crawler.items import JbkRlationItem

class JbkSpider(CrawlSpider):
    name = "jbk_relation"
    allowed_domains = ["39.net",]
    start_urls = []

    for idx in range(1, 791):
        start_urls.append('http://jbk.39.net/bw_t1_p' + str(idx) )

    for idx in range(1, 659):
        start_urls.append('http://jbk.39.net/bw_t2_p' + str(idx) )

    rules = (
        Rule(SgmlLinkExtractor(allow=(r'http://jbk.39.net/bw_t1_p*')), follow = False, callback="parse_item_1"), 
        Rule(SgmlLinkExtractor(allow=(r'http://jbk.39.net/bw_t2_p*')), follow = False, callback="parse_item_2"), 
    )

    def parse_item_1(self, response):
        for item in self.parse_item(response, 'disease'):
            yield item

    def parse_item_2(self, response):
        for item in self.parse_item(response, 'symp'):
            yield item

    def parse_item(self, response, dis_sym):
        hxs = Selector(response)
        jbs = hxs.xpath('//div[contains(@class, "res_list")]')
        items = []
        #print "[url]" + response.url
        for jb in jbs:
            item = JbkRlationItem()
            item['dis_sym'] = dis_sym
            name = ''.join(jb.xpath('./dl/dt/h3/a/text()').extract())
            relas = jb.xpath('./div[contains(@class, "other clearfix")]/p/a/text()')
            relations = []
            for rela in relas:
                relations.append(rela.extract())
            item['name'] = name
            item['relations'] = relations
            items.append(item)

        return items
