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

from crawler.items import JbkItem

class JbkSpider(CrawlSpider):
    name = "jbk"
    allowed_domains = ["39.net",]
    start_urls = [
        #"http://jbk.39.net/bw",  #jibin & zhengzhuang zonghe home page
        "http://jbk.39.net/bw_t1",  #jibin home page
        #"http://jbk.39.net/bw_t2",  #zhengzhuang home page
    ]
    rules = (
        Rule(SgmlLinkExtractor(allow=(r'http://jbk.39.net/*')), follow = True, callback="parse_item"), 
    )

    name_dict = {
        u'别名：' : 'alias_name',
        u'发病部位：' : 'location',
        u'传染性：' : 'infectious',
        u'多发人群：' : 'crowd',
        u'相关症状：' : 'symptom',
        u'并发疾病：' : 'related_disease',
        u'就诊科室：' : 'department',
        u'治疗费用：' : 'cost',
        u'治愈率：' : 'cure_rate',
        u'治疗方法：' : 'cure_method',
        u'相关检查：' : 'inspection',
        u'相关手术：' : 'operation',
        }

    def parse_item(self, response):
        hxs = Selector(response)
        jbs = hxs.xpath('//section[contains(@class, "main wrap")]/header[contains(@class, "list_tit")]/h1/b/text()')
        cites = hxs.xpath('//section[contains(@class, "main wrap")]/header[contains(@class, "list_tit")]/h1/cite[contains(@class, "bg1")]/text()')
        #print "[url]" + response.url
        if jbs and cites:
            item = JbkItem()
            item["url_string"] = response.url
            item["disease_name"] = "".join(jbs.extract())
            item["class_name"] = "".join(cites.extract())
            #print '[url]' + response.url
            #print "[disease_name]" + item["disease_name"].encode('utf-8')
            #print "[class_name]" + item["class_name"].encode('utf-8')

            hxs_detail = hxs.xpath('//div[contains(@class, "list_head catalogItem")]/div[contains(@class, "intro clearfix")]/dl/dd[contains(@id, "intro")]/p/text()')
            if hxs_detail:
                item['introduction'] = ''.join(hxs_detail.extract())

            hxs_detail = hxs.xpath('//div[contains(@class, "list_head catalogItem")]/div[contains(@class, "clearfix")]/div[contains(@class, "intel")]/dl')
            if not hxs_detail:
                return

            for sth in hxs_detail:
                key = sth.xpath('./dt/text()').extract()
                key_str = ",".join(key).strip()

                value = sth.xpath('./dd')
                if value.xpath('./a'):
                    value_str = value.xpath('./a/text()').extract()
                else:
                    value_str = value.xpath("text()").extract()
                value_str = ",".join(value_str).strip()

                if key_str in self.name_dict:
                    item[self.name_dict[key_str]] = value_str
                #else:
                    #print 'unkwon [key]:[' + key_str + '], [value]:[' + value_str + ']'
                
            return item

