#! /usr/bin/py

import os
import sys

class StockData:
    def __init__(self):
        self.stock_data = {}

    def add_stock_data(self, fields):
        stock_code = fields[0]
        stock_data_cate = fields[1]
        stock_date = fields[2]
        records = fields[3:]
        stock_key = '\t'.join([stock_code, stock_data_cate, stock_date])
        self.stock_data[stock_key] = records

    def get_data(self, stock_code, stock_date, stock_data_cate):
        key = '\t'.join([stock_code, stock_date, stock_data_cate])
        return self.stock_data.get(key, None)

    def write_file(self, out_filename):
        file_writer = open(out_filename, 'w')
        for (k, v) in self.stock_data.items():
            [stock_code, stock_data_cate, stock_date] = k.split('\t')
            sz_records = self.get_data('sh000001', 'ifeng', stock_date)
            fund_records = v
            if stock_data_cate != "fund":
                continue
            hd_records = self.get_data(stock_code, 'hd', stock_date)
            ifeng_records = self.get_data(stock_code, 'ifeng', stock_date)
            if (fund_records is None) or (hd_records is None) or \
                    (ifeng_records is None) or (sz_records is None):
                print 'miss some data:' + stock_code + '_' + stock_date
                continue

            stock_records = []
            stock_records.extend(hd_records)
            stock_records.extend(fund_records[6:])
            stock_records.extend(ifeng_records[4:6] + ifeng_records[7:-1])
            stock_records.extend(sz_records)
            out_records = [stock_code, stock_date]
            out_records.extend(stock_records)
            if (len(out_records) >=45):
                file_writer.write('\t'.join(out_records) + '\n')
        file_writer.close()


stock_data = StockData()

def file_process(arg, dirname, names):
    for filepath in names:
        filename = os.path.join(dirname, filepath)
        if not os.path.isfile(filename):
            continue
        for line in open(filename):
            line = ''.join(line.split(','))
            fields = line[:-1].split('\t')
            stock_data.add_stock_data(fields)

def main():
    if len(sys.argv) < 3:
        print "lack of parameters"
        return
    os.path.walk(sys.argv[1], file_process,())
    stock_data.write_file(sys.argv[2])
    
if __name__ == "__main__":
    main()
    
