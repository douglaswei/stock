#! /usr/bin/python
# coding=utf-8

import common
import time
import logging
from preprocess import DBDataToPickle
from .function import *
from .label import labelGenerate
import multiprocessing
from multiprocessing import Pool, Manager

CONSUME_NUM = 4


def p_func(o, queue):
    logging.debug('p_func')

    for is_train,label,feat_records,lock in o.generate_records():
        logging.debug(str(is_train) +':'+ str(feat_records))
        args =  (is_train, label, feat_records, lock)
        queue.put(args)

    for i in range(CONSUME_NUM):
        queue.put(None)


def c_func(o, q):
    logging.debug('c_func')
    while True:
        args = q.get()
        if args is None:
            return
        logging.debug('consume:' + str(args))
        o.consume_records(args)

class FeatProcessor(object):
    '''
    对于某一code下处理好的数据，按照给定的处理函数，抽取特征
    '''
    def __init__(self, config = common.config()):
        self.__config = config


    def extractFeatures(self, feat_extractor, label_func):
        self.feat_extractor = feat_extractor
        self.label_func = label_func
        max_num = 1000
        queue = Manager().Queue(max_num)
        self.lock = Manager().Lock()

        #p_func(self, queue)
        #return
    
        pool = Pool(processes=CONSUME_NUM + 1)

        pool.apply_async(p_func, (self, queue))
        for i in range(CONSUME_NUM):
            pool.apply_async(c_func, (self, queue))
        pool.close()
        pool.join()


    def generate_records(self):
        in_filename = self.__config.pickle_records_file

        dbdata = DBDataToPickle()
        for records in dbdata.load_records(in_filename):
            for is_train,label,feat_records in self.gen_label_and_feat_records(records, self.label_func):
                logging.debug(str(is_train) +':'+ str(feat_records))
                yield (is_train, label, feat_records, self.lock)


    def consume_records(self, args):
        logging.debug('consume:'+str(args))
        self.feat_extractor.process(*args)


    def gen_label_and_feat_records(self, records, label_func):
        for label_beg in range(len(records)):
            label_end = label_beg + self.__config.label_window
            feat_end = label_end + self.__config.feat_window
            if feat_end > len(records):
                # 忽略长度不够的reocrds
                logging.debug('ignore recors of length too short')
                break
            label = label_func(records, self.__config)
            yield (True, label, records[label_end:feat_end])

        if len(records) >= self.__config.feat_window:
            yield (False, 0, records[:self.__config.feat_window])

