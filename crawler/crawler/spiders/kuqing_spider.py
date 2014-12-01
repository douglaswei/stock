#!/usr/bin/python
#****************************************************************#
# ScriptName: crawler/spiders/kuqing_spider.py
# Create Date: 2014-06-18 22:02
# Modify Date: 2014-06-18 22:02
#***************************************************************#

from scrapy.contrib.spiders import CrawlSpider, Rule
from scrapy.contrib.linkextractors.sgml import SgmlLinkExtractor
from scrapy.selector import HtmlXPathSelector

from crawler.items import DmozItem

class BaiduSpider(CrawlSpider):
    name = "baiduspider"
    allowed_domains = ["baidu.com",]
    start_urls = [
        "http://baike.baidu.com/fenlei/%E4%BC%A0%E7%BB%9F%E5%8C%BB%E5%AD%A6",
    ]
    rules = (
        Rule(SgmlLinkExtractor(allow=(r'http://baike.baidu.com/view/\d+.htm')), follow = True, callback="parse_item"), 
        Rule(SgmlLinkExtractor(allow=(r'http://baike.baidu.com/fenlei/*.htm')), follow = False),
    )

    def parse_item(self, response):
        hxs = HtmlXPathSelector(response)
        sites = hxs.select('//div[contains(@class, "card-summary-content")]/div[contains(@class, "para")]/text()')
        items = []
        str = "".join(site.extract() for site in sites)
        str_g = str.encode("gbk")
        open("res", "a").write(str_g)

        keyword = hxs.select('//div[contains(@class, "lemmaTitleH1")]/text()')
        print "[url]" + response.url
        print "[keyword]" + keyword[0].extract()
        print "[utf-8]" + str.encode("utf-8")
