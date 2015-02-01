#! /usr/bin/python
# coding=utf-8 

import logging
import cPickle as pickle
from model.orm import DB_Engine
from function import adjust_gegu_records
import common

class DBDataToPickle(object):
    def __init__(self, config=common.config()):
        self.config = config
        self.db_engine = DB_Engine(self.config.db_string)
        self.filename = self.config.pickle_records_file


    def generate_records(self):
        fout = open(self.filename, 'wb')
        gegu_codes = self.db_engine.get_gegu_codes()
        logging.info(gegu_codes)
        for gegu_code in gegu_codes:
            records = self.db_engine.get_gegu_records(gegu_code[0])
            # fuquan
            adjust_gegu_records(records)
            #for feat_proc_records in self.generate_records_4_feat_process(records):
            pickle.dump(records, fout)
            for ele in records:
                logging.debug(str(ele))
        fout.close()
            

    def load_records(self, filename):
        fin = open(filename, 'rb')
        while True:
            try:
                record = pickle.load(fin)
            except Exception,e:
                break
            yield record
        fin.close()


