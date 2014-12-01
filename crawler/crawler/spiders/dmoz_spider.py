#!/usr/bin/python
#****************************************************************#
# ScriptName: dmoz_spider.py
# Create Date: 2014-06-17 15:02
# Modify Date: 2014-06-17 15:02
#***************************************************************#

from scrapy.spider import Spider
from scrapy.selector import HtmlXPathSelector

from crawler.items import DmozItem

class DmozSpider(Spider):
    name = "dmoz"
    allowed_domains = ["dmoz.org"]
    start_urls = [
        "http://www.dmoz.org/Computers/Programming/Languages/Python/Books/",
        "http://www.dmoz.org/Computers/Programming/Languages/Python/Resources/",
        "http://www.dmoz.org/Computers/Programming/Languages/Comparison_and_Review/",
        "http://www.dmoz.org/Computers/Programming/Languages/Interpreted/Bytecode/",
        "http://www.dmoz.org/Computers/Programming/Languages/Object-Oriented/Class-based/",
        "http://www.dmoz.org/Computers/Programming/Languages/Multiparadigm/",
        "http://www.dmoz.org/Computers/Programming/Languages/Scripting/Object-Oriented/",
    ]

    def parse(self, response):
        hxs = HtmlXPathSelector(response)
        sites = hxs.xpath('//ul/li')
        items = []
        for site in sites:
            item = DmozItem()
            item['title'] = site.xpath('a/text()').extract()
            item['link'] = site.xpath('a/@href').extract()
            item['desc'] = site.xpath('text()').extract()
            print item['title'], item['link']
        #    items.append(item)
        #return items
