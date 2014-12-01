#!/usr/bin/python
#****************************************************************#
# ScriptName: medical.py
# Create Date: 2014-06-17 15:02
# Modify Date: 2014-06-17 15:02
#***************************************************************#

from scrapy.spider import Spider
from scrapy.selector import HtmlXPathSelector

from crawler.items import DmozItem

class DmozSpider(Spider):
    name = "medical_sym"
    allowed_domains = ['yi18.net']
    url_prefix = 'http://medical.yi18.net/symptom/?p='
    start_urls = []
    for idx in range(1, 33):
        url = url_prefix + str(idx)
        start_urls.append(url)

    def parse(self, response):
        hxs = HtmlXPathSelector(response)
        syms = hxs.xpath('//h3/a/text()')
        for sym in syms:
            print sym.extract().encode('utf-8')
