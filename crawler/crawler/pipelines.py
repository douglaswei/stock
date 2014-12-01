# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: http://doc.scrapy.org/en/latest/topics/item-pipeline.html

import os
from crawler.local_settings import STOCK_DATA_DIR, TODAY_STR, DESIRED_DATE_STR
from crawler.items import StockItem
from scrapy import log

class IfengPipeline(object):
    def __init__(self):
        if not os.path.exists(STOCK_DATA_DIR):
            os.mkdir(STOCK_DATA_DIR)
        output_filename = STOCK_DATA_DIR + "ifeng_" + TODAY_STR
        if os.path.exists(output_filename):
            log.msg("file exists:[" + output_filename + "]", level=log.INFO)
        self.file = open(output_filename, 'a')
        if self.file is None:
            log.msg("file open fail:[" + output_filename + "]", level=log.ERROR)

    def process_item(self, item, spider):
        if not isinstance(item, StockItem) or item['cate'] != 'ifeng':
            return item

        for record in item["records"]:
            fields = []
            fields.append(item['code'])
            fields.append(item['cate'])
            fields.extend(record)
            fields[2] = "".join(fields[2].split('-'))
            self.file.write("\t".join(fields)+"\n")


class BestgoPipeline(object):
    def __init__(self):
        out_dir = STOCK_DATA_DIR + '/bestgo/'
        if not os.path.exists(out_dir):
            os.mkdir(out_dir)
        output_filename = out_dir + DESIRED_DATE_STR
        if os.path.exists(output_filename):
            log.msg("file exists:[" + output_filename + "]", level=log.INFO)
        self.file = open(output_filename, 'a+')
        if self.file is None:
            log.msg("file open fail:[" + output_filename + "]", level=log.ERROR)

    def process_item(self, item, spider):
        if (not isinstance(item, StockItem)) or \
                (item['cate'] != 'fund' and item['cate'] != 'hd'):
            return item
        fields = []
        fields.append(item['code'])
        fields.append(item['cate'])
        fields.append(DESIRED_DATE_STR)
        fields.extend(item['records'][1:])
        self.file.write("\t".join(fields)+"\n")
