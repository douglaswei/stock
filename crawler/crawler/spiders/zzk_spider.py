#coding=utf-8
from scrapy.contrib.spiders import CrawlSpider, Rule
from scrapy.contrib.linkextractors.sgml import SgmlLinkExtractor
from scrapy.selector import Selector

from crawler.items import ZzkItem
from crawler.items import DiseaseItem

class ZzkSpider(CrawlSpider):
    name = "zzk"
    allowed_domains = ["39.net",]
    start_urls = [
        "http://jbk.39.net/bw_t2",  #zhengzhuang home page
    ]
    rules = (
        Rule(SgmlLinkExtractor(allow=(r'http://jbk.39.net/*')), follow = True, callback="parse_item"), 
    )


    def parse_item(self, response):
    	hxs = Selector(response)
        div_xpath = hxs.xpath('//section[contains(@class, "main wrap")]/div[contains(@class, "list_con clearfix")]')
    	symptoms_tag = hxs.xpath('//section[contains(@class, "main wrap")]/header[contains(@class, "list_tit")]/h1/cite[contains(@class, "bg2")]/text()').extract()
        sheet_name = hxs.xpath('//section[contains(@class, "main wrap")]/header[contains(@class, "list_tit")]//div[contains(@id, "list_nav")]//li[contains(@class, "h")]/text()').extract()
    	#如果标签不是症状，或没有标签则返回
        if (cmp(str(symptoms_tag), "[u'\u75c7\u72b6']") == 0) and (cmp(str(sheet_name), "[u'\u7efc\u8ff0']") == 0):
            item = ZzkItem()
            item["url"] = response.url
            symptoms_name = hxs.xpath('//section[contains(@class, "main wrap")]/header[contains(@class, "list_tit")]/h1/b/text()').extract()
            item["symptoms_name"] = symptoms_name
            symptoms_description = hxs.xpath('//section[contains(@class, "main wrap")]/div[contains(@class, "list_con clearfix")]//dd[contains(@id, "intro")]/p[contains(@class, "sort2")]/text()').extract()
            item["symptoms_description"] = symptoms_description

            disease_info_list_path = div_xpath.xpath('//div[contains(@class, "item")]//table[contains(@class, "dis")]/tr')
            if not disease_info_list_path:
                return

            disease_item_list = []
            for disease_info in disease_info_list_path:
                class_name = disease_info.xpath('.//@class').extract()

                if cmp(str(class_name), "[u'name']") == 0:        
                    disease_info_xpath = disease_info.xpath('./td')
                    disease_list = []
                    disease_url = disease_info.xpath('./td[contains(@class, "name")]/a/@href').extract()
                    
                    for disease in disease_info_xpath:
                        disease_name = disease.xpath('./a/@title').extract()
                        disease_list.append(disease_name)

                    disease_item = DiseaseItem()
                    disease_item["disease_name"] = disease_list[0]
                    disease_item["symptoms"] = disease_list[1]
                    disease_item["department"] = disease_list[2]
                    disease_item["disease_url"] = disease_url
                    disease_item_list.append(disease_item)

            item["disease"] = disease_item_list


            return item





