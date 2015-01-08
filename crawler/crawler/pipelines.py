# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: http://doc.scrapy.org/en/latest/topics/item-pipeline.html

import os
from crawler.local_settings import STOCK_DATA_DIR, TODAY_STR, DESIRED_DATE_STR, DUMP_FILENAME
from crawler.items import StockItem
from scrapy import log
from datetime import date

class IfengPipeline(object):
    def __init__(self):
        if not os.path.exists(STOCK_DATA_DIR):
            os.mkdir(STOCK_DATA_DIR)
        output_filename = STOCK_DATA_DIR + os.path.sep + "ifeng_" + TODAY_STR
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

        return item


class BestgoPipeline(object):
    def __init__(self):
        out_dir = STOCK_DATA_DIR + os.path.sep + 'bestgo'
        if not os.path.exists(out_dir):
            os.mkdir(out_dir)
        output_filename = out_dir + os.path.sep + DESIRED_DATE_STR
        if os.path.exists(output_filename):
            log.msg("file exists:[" + output_filename + "]", level=log.INFO)
        self.file = open(output_filename, 'w')
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

        return item


class CatePipeline(object):
    def __init__(self):
        if not os.path.exists(STOCK_DATA_DIR):
            os.mkdir(STOCK_DATA_DIR)
        output_filename = STOCK_DATA_DIR + os.path.sep + "ifeng_cate"
        if os.path.exists(output_filename):
            log.msg("file exists:[" + output_filename + "]", level=log.INFO)
        self.file = open(output_filename, 'w')
        if self.file is None:
            log.msg("file open fail:[" + output_filename + "]", level=log.ERROR)

    def process_item(self, item, spider):
        if not isinstance(item, StockItem) or item['cate'] != 'cate':
            return item

        fields = []
        fields.append(item['code'])
        fields.append(item['cate'])
        fields.extend(item['records'])
        self.file.write("\t".join(fields)+"\n")

        return item


class DumpFilePipeline(object):
    def __init__(self):
        if not os.path.exists(DUMP_FILENAME):
            log.msg("file exists:[%s]" % DUMP_FILENAME)
        filename = DUMP_FILENAME + '_' + date.today().strftime('%Y%m%d')
        self.dump_file = open(filename, 'w')


    def process_item(self, item, spider):
        fields = []
        for k,v in sorted(item.items(), key=lambda tups:tups[0]):
            if v is not None:
                fields.append(k+":"+str(v))
        out_str = '\t'.join(fields).encode('utf-8')
        self.dump_file.write(out_str + '\n')
        return item


class DumpDBPipeline(object):
    def __init__(self):
        pass

    def process_item(self, item, spider):
        return item
