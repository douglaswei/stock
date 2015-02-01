#! /usr/bin/python
# coding=utf-8

import sys
import os
import cPickle
import logging
import random
import numpy as np
import gc
import logging

import common
from .records import fundRecords, hdRecords
from .function import *
from .label import labelGenerate


__all__ = []


class RecordsSampler(object):
    def __init__(self, config=common.config):
        self.__config = config


    def sample(self, input_filename, output_filename):
        pos_num = 0
        neg_num = 0
        fin = open(self.__config.sample_file_in)
        for line in fin.readlines():
            items = line[:-1].split('\t')
            if float(items[2]) > 0:
                pos_num += 1
            else:
                neg_num += 1
        fin.close()

        ratio = pos_num / float(neg_num) / self.__config.sample_pn_ratio
        fin = open(input_filename)
        fout = open(output_filename, 'w')
        for line in fin.readlines():
            items = line[:-1].split('\t')
            lable_idx = self.__config.feat_begin_idx - 1
            if float(items[2]) < 0:
                if self.__config.sample_postive_only:
                    continue
                random_num = random.random()
                if random_num > ratio:
                    continue
            fout.write(line)
        fin.close()
        fout.close()


class Uniformer(object):
    def uniform(self, input_filenames, output_filenames):
        value_dict = {}
        for filename in input_filenames:
            for line in open(filename):
                items = line[:-1].split('\t')
                for item in items[3:]:
                    k,v = item.split(':')
                    v = float(v)
                    value = value_dict.get(k, {})
                    max_value = value.get('max', None)
                    min_value = value.get('min', None)
                    if max_value is None or v > max_value:
                        max_value = v
                    if min_value is None or v < min_value:
                        min_value = v
                    value['max'] = max_value
                    value['min'] = min_value
                    value_dict[k] = value

        for k, v_d in value_dict.items():
            max_value = v_d['max']
            min_value = v_d['min']
            span = max_value - min_value
            if span == 0 :
                span += 0.0000001
            v_d['span'] = span

        for infile, outfile in zip(input_filenames, output_filenames):
            fout = open(outfile, 'w')
            for line in open(infile):
                items = line[:-1].split('\t')
                res_items = items[:3]
                for item in items[3:]:
                    k,v = item.split(':')
                    v = float(v)
                    min_value = value_dict[k]['min']
                    span = value_dict[k]['span']
                    v = (v - min_value) / span
                    res_items.append('%s:%f' % (k, v))
                fout.write('\t'.join(res_items) + '\n')
            fout.close()


class BaseTranslator(object):
    def __init__(self):
        self.m_dict = {}

    def translate(self, infile, outfile, feat_begin_idx):
        fout = open(outfile, 'w')
        for line in open(infile):
            items = line[:-1].split('\t')
            output_feats = items[:feat_begin_idx]
            feats = []
            for item in items[feat_begin_idx:]:
                k, v = item.split(':')
                kid,v = self.getKV(k, v)
                feats.append([kid, v])
            output_feats.extend( [str(ele[0]) + ':' + ele[1] for ele in sorted(feats, key = lambda x: x[0])])
            fout.write('\t'.join(output_feats) + '\n')
        fout.close()


class FeatTranslator(BaseTranslator):
    def getKV(self, k, v):
        kid = self.m_dict.get(k, None)
        if kid is None:
            kid = len(self.m_dict) + 1
            self.m_dict[k] = kid
        return kid, v


class IDFeatTranslator(BaseTranslator):
    def getKV(self, k, v):
        item = k + ':' + v
        kid = self.m_dict.get(item, None)
        if kid is None:
            kid = len(self.m_dict) + 1
            self.m_dict[item] = kid
        return kid, '1'


