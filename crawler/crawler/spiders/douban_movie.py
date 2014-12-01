from scrapy.selector import Selector
from scrapy.contrib.spiders import CrawlSpider,Rule
from scrapy.contrib.linkextractors.sgml import SgmlLinkExtractor

from scrapy import log

class MoiveSpider(CrawlSpider):
    name="doubanmoive"
    allowed_domains=["movie.douban.com"]
    start_urls=["http://movie.douban.com/top250"]
    rules=[
        Rule(SgmlLinkExtractor(allow=(r'http://movie.douban.com/top250')),callback="parse_250", follow = False),
    ]

    def parse_item(self,response):
#        log.msg(response.url, log.DEBUG)
        sel=Selector(response)
        log.msg(sel.xpath('//*[@id="content"]/h1/span[1]/text()').extract(), log.DEBUG)

    def parse_250(self,response):
        log.msg(response.url, log.DEBUG)

