#coding=utf-8
from scrapy.contrib.spiders import CrawlSpider, Rule
from scrapy.contrib.linkextractors.sgml import SgmlLinkExtractor
from scrapy.selector import Selector

from crawler.items import YybItem

class YybSpider(CrawlSpider):
    name = "yyb"
    allowed_domains = ["yi18.net",]
    start_urls = [
        "http://medical.yi18.net/disease",  #yi18
    ]
    rules = (
        Rule(SgmlLinkExtractor(allow=(r'http://medical.yi18.net/disease/*')), follow = True, callback="parse_item"), 
    )


    def parse_item(self, response):
    	hxs = Selector(response)
        div_xpath = hxs.xpath('//div[contains(@id, "res_tab_1")]/div[contains(@class, "res_list")]')

        if not div_xpath:
            return

        for div in div_xpath:
            item = YybItem()
            disease_name = div.xpath('./dl/dt[contains(@class, "clearfix")]/h3/a/@title').extract()
            item['disease_name'] = disease_name
            disease_url = div.xpath('./dl/dt[contains(@class, "clearfix")]/h3/a/@href').extract()
            item['disease_url'] = disease_url
            department = div.xpath('./dl/dt[contains(@class, "clearfix")]/span[contains(@class, "price")]/text()').extract()
            item['department'] = department[0].split("|")
            
            if div.xpath('./dl/dd/p'):
                description = div.xpath('./dl/dd/p[1]/text()').extract()
            else:
                description = div.xpath('./dl/dd/text()').extract()

            item['description'] = description
            symptoms_name = div.xpath('./div[contains(@class, "other clearfix")]/p/a/text()').extract()
            item['symptoms_name'] = symptoms_name[0].split("|")

            return item






