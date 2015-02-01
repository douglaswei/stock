# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: http://doc.scrapy.org/en/latest/topics/item-pipeline.html

# coding = utf-8

import os
import codecs

from crawler.local_settings import STOCK_DATA_DIR, DUMP_FILENAME, DB_STR
from crawler.items import StockItem
from scrapy import log
from datetime import datetime,date
from crawler.model.orm import DB_Engine


class BestgoPipeline(object):
    def __init__(self):
        out_dir = STOCK_DATA_DIR + os.path.sep + 'bestgo'
        if not os.path.exists(out_dir):
            os.mkdir(out_dir)
        CURRENT_TIME = datetime.today().strftime("%Y%m%d_%H%M%S")
        output_filename = out_dir + os.path.sep + CURRENT_TIME
        if os.path.exists(output_filename):
            log.msg("file exists:[" + output_filename + "]", level=log.INFO)
        self.file = open(output_filename, 'w')
        if self.file is None:
            log.msg("file open fail:[" + output_filename + "]", level=log.ERROR)

    def process_item(self, item, spider):
        if (not isinstance(item, StockItem)) or \
                (item['channel'] != 'fund' and item['channel'] != 'hd'):
            return item
        fields = []
        fields.append(item['code'])
        fields.append(item['channel'])
        fields.append(item['cdate'])
        fields.extend(item['records'][1:])
        self.file.write("\t".join(fields)+"\n")

        return item


class CatePipeline(object):
    def __init__(self):
        if not os.path.exists(STOCK_DATA_DIR):
            os.mkdir(STOCK_DATA_DIR)
        output_filename = STOCK_DATA_DIR + os.path.sep + "ifeng_cate"
        if os.path.exists(output_filename):
            log.msg("file exists:[" + output_filename + "]", level=log.INFO)
        self.file = codecs.open(output_filename, 'w')
        if self.file is None:
            log.msg("file open fail:[" + output_filename + "]", level=log.ERROR)

    def process_item(self, item, spider):
        if not isinstance(item, StockItem) or item['channel'] != 'cate':
            return item

        fields = []
        fields.append(item['code'])
        fields.append(item['channel'])
        fields.extend(item['records'])
        self.file.write("\t".join(fields)+"\n")

        return item


class DumpFilePipeline(object):
    def __init__(self):
        if not os.path.exists(DUMP_FILENAME):
            log.msg("file exists:[%s]" % DUMP_FILENAME)
        filename = DUMP_FILENAME + '_' + datetime.today().strftime('%Y%m%d_%H%M%S')
        self.dump_file = codecs.open(filename, 'w', 'utf-8')

    def process_item(self, item, spider):
        fields = []
        for k,v in sorted(item.items(), key=lambda tups:tups[0]):
            if v is not None:
                if isinstance(v, list):
                    v = '|'.join(v)
                if isinstance(v, datetime):
                    v = str(v)
                v = v.replace(',', '')
                fields.append(k + ":" + v)
        out_str = '\t'.join(fields)
        self.dump_file.write(out_str + '\n')
        return item


class DumpDBPipeline(object):
    def __init__(self):
        self.db_engine = DB_Engine(DB_STR)
        self.db_engine.create_table()


    def process_item(self, item, spider):
        self.db_engine.process_item(item)
        return item
