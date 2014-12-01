#!/usr/bin/python
#****************************************************************#
# ScriptName: crawler/spiders/douban_spider.py
# Create Date: 2014-06-17 17:05
# Modify Date: 2014-06-17 17:05
#***************************************************************#

from scrapy.spider import Spider
from scrapy.selector import Selector
from crawler.items import DoubanItem

import re

class doubanSpider(Spider):
    name = "douban"
    allowed_domains = ["douban.com"]
    start_urls = [
        "http://www.douban.com/group/ProductManager/",
    ]

    def __get_id_from_group_url(self, url):
        m =  re.search("^http://www.douban.com/group/([^/]+)/$", url)
        if(m):
            return m.group(1) 
        else:
            return 0

    def parse(self, response):
        self.log("Fetch group home page: %s" % response.url)

        hxs = Selector(response)
        item = DoubanItem()

        #get group name
        item['groupName'] = hxs.xpath('//h1/text()').re("^\s+(.*)\s+$")[0]

        #get group id
        item['groupURL'] = response.url
        groupid = self.__get_id_from_group_url(response.url)

        #get group members number
        members_url = "http://www.douban.com/group/%s/members" % groupid
        #a[contains(@href, "%s")]
        members_text = hxs.xpath('//a[contains(@href, "%s")]/text()' % members_url).re("\((\d+)\)")
        item['totalNumber'] = members_text[0]

        #get relative groups
        item['RelativeGroups'] = []
        groups = hxs.xpath('//div[contains(@class, "group-list-item")]')

        for group in groups:
            url = group.xpath('div[contains(@class, "title")]/a/@href').extract()[0]
            item['RelativeGroups'].append(url)

        return item
