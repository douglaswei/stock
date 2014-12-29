#! /usr/bin/py
# -*- coding: utf-8 -*-

import os
import sys
import pickle
import numpy as nu

from stockCommon import *


class BaseFeatureExtractor(object):
    sz_code = "sz399001"
    sh_code = "sh000001"
    _fieldMap = {
            'ma' : 0,
            'ma5' : 1,
            'ma10' : 2,
            'ma20' : 3,
            'exchange' : 4,
            'exchange5' : 5,
            'exchange10' : 6,
            'exchange20' : 7,
            'ma_gradient' : 8,
            'hsl' : 9,
            'ltsz' : 10,
            'zjlr' : 11,
            'ydjl' : 12,
            'szdata' : 13,
            }


    def __init__(self, file_prefix):
        self.train_filename = file_prefix + "_train"
        self.trainfile = open(self.train_filename, 'w')
        self.test_filename = file_prefix + "_test"
        self.testfile = open(self.test_filename, 'w')
        

    def __del__(self):
        if self.trainfile is not None:
            self.trainfile.close()
        if self.testfile is not None:
            self.testfile.close()


    def getMaFeatures(self, records):
        pass


    def getExchangeFeatures(self, records):
        pass


    def getLtszFeatures(self, records):
        pass


    def getZjlrFeatures(self, records):
        pass


    def getYdjlFeatures(self, records):
        pass


    def getSzdataFeatures(self, records):
        pass


    def getExtraFeat(self, full_records):
        pass


    def extract_window_feature(self, windowRecords):
        res_features = []
        func_dict = {
            'ma' : self.getMaFeatures,
            'exchange' : self.getExchangeFeatures,
            'ltsz' : self.getLtszFeatures,
            'zjlr' : self.getZjlrFeatures,
            'ydjl' : self.getYdjlFeatures,
            'szdata' : self.getSzdataFeatures
        }
        for key, func in func_dict.items():
            feat_dict = func(windowRecords[:, self._fieldMap[key]])
            if feat_dict is not None:
                res_features.extend(["%s:%f" % (k,v) for k,v in feat_dict.items()])
        feat_dict = self.getExtraFeat(windowRecords)
        if feat_dict is not None:
            res_features.extend(["%s:%s" % (k,v) for (k,v) in feat_dict.items()])

        return res_features


class AdvancedFeatureExtractor(BaseFeatureExtractor):
    def getMaFeatures(self, records):
        return {}


    def getExchangeFeatures(self, records):
        return {
            # 5天换手率的变化率 * 100
            'ex_gradient_0_5_5_5' : _Grandient(records, 0, 5, 5, 5),
            # 10天换手率的变化率 * 100
            'ex_gradient_0_10_10_10' : _Grandient(records, 0, 10, 10, 10),
            # 20天换手率的变化率 * 100
            'ex_gradient_0_20_20_20' : _Grandient(records, 0, 20, 20, 20),
            # 5_100天换手率的变化率 * 100
            'ex_gradient_0_100_100_100' : _Grandient(records, 0, 0, 5, 100),
        }


    def getLtszFeatures(self, records):
        return {
            'ltsz_grad_0_5_5_5' : _Grandient(records, 0, 5, 5, 5),
            'ltsz_variance_10' : _Variance(records[:10]),
            'ltsz_variance_20' : _Variance(records[:20]),
            'ltsz_variance_30' : _Variance(records[:30]),
            'ltsz_variance_60' : _Variance(records[:60]),
        }


    def getZjlrFeatures(self, records):
        return {
            'zjlr_grad_0_5_5_5' : _Grandient(records, 0, 5, 5, 5),
            'zjlr_postive_num_5' : _Pos(records, 5),
            'zjlr_postive_num_10' : _Pos(records, 10),
            'zjlr_variance_10' : _Variance(records[:10]),
            'zjlr_variance_20' : _Variance(records[:20]),
            'zjlr_variance_30' : _Variance(records[:30]),
            'zjlr_variance_60' : _Variance(records[:60]),
        }


    def getYdjlFeatures(self, records):
        return {
            'zjlr_grad_0_5_5_5' : _Grandient(records, 0, 5, 5, 5),
            'zjlr_postive_num_5' : _Pos(records, 5),
            'zjlr_postive_num_10' : _Pos(records, 10),
            'zjlr_variance_10' : _Variance(records[:10]),
            'zjlr_variance_20' : _Variance(records[:20]),
            'zjlr_variance_30' : _Variance(records[:30]),
            'zjlr_variance_60' : _Variance(records[:60]),
        }


    def getSzdataFeatures(self, records):
        '''
        1. 最近10天的偏方差
        2. 最近10天涨幅
        '''
        return {
            "szdata_variance" : _Variance(records[:10]),
            "szdata_gradient10" : _Grandient(records, 0, 0, 3, 10),
            }


    def getExtraFeat(self, full_records):
        return {}


class LrFeatureExtractor(AdvancedFeatureExtractor):
    def getMaFeatures(self, records):
        '''
        '''
        return {
            # 10天方差
            'ma_variance_10' : _Variance(records[:10]),
            # 20天方差
            'ma_variance_20' : _Variance(records[:20]),
            # 30天方差
            'ma_variance_30' : _Variance(records[:30]),
            # 60天的方差
            'ma_variance_60' : _Variance(records[:60]),
            # 20天ma3涨幅
            'ma_gradient_0_20_3_3' : _Grandient(records, 0, 20, 3, 3),
            # 30天ma5涨幅
            'ma_gradient_0_30_5_5' : _Grandient(records, 0, 30, 5, 5),
            # 60天ma5涨幅
            'ma_gradient_0_60_5_5' : _Grandient(records, 0, 60, 5, 5),
            # 100天ma10涨幅
            'ma_gradient_0_100_10_10' : _Grandient(records, 0, 100, 10, 10),
            # 230天ma10涨幅
            'ma_gradient_0_230_10_10' : _Grandient(records, 0, 230, 10, 10),
            # ma1_ma5涨幅
            'ma_gradient_0_0_1_5' : _Grandient(records, 0, 0, 1, 5),
            # ma1_ma10涨幅
            'ma_gradient_0_0_1_10' : _Grandient(records, 0, 0, 1, 10),
            # ma1_ma30涨幅
            'ma_gradient_0_0_1_30' : _Grandient(records, 0, 0, 1, 30),
            # ma1_ma60涨幅
            'ma_gradient_0_0_1_60' : _Grandient(records, 0, 0, 1, 60),
            # ma1_ma100涨幅
            'ma_gradient_0_0_1_100' : _Grandient(records, 0, 0, 1, 100),
            # 60天在处于上升通道的天数
            'ma_cout_increase_days_60' : _CountDaysShangshenTongDao(records, 60),
        }


class KnnFeatureExtractor(AdvancedFeatureExtractor):
    def getMaFeatures(self, records):
        '''
        '''
        feature_dict = {}
        # [5,20],[10,20],[20,30],[30,60] 上升通道
        # 小窗口3、5、10、20天的所有梯度
        for sample_rate in [3, 5, 10, 20]:
            grads = _GradientsBySample(records[:100], sample_rate)
            for idx in range(len(grads)):
                key = 'ma_grad_sample_%d_idx_%d' % (sample_rate, idx)
                feature_dict[key] = grads[idx] * sample_rate * 100

        # 60天10天为小窗口内上升通道天数
        for idx in range(6):
            key = 'ma_increase_count_%d' % idx
            feature_dict[key] = _CountDaysShangshenTongDao(records[idx*10:], 10)
        # 10天方差
        feature_dict["ma_var_10"] = _Variance(records[:10])
        # 20天方差
        feature_dict["ma_var_20"] = _Variance(records[:20])
        # 30天方差
        feature_dict["ma_var_30"] = _Variance(records[:30])
        # 60天方差
        feature_dict["ma_var_60"] = _Variance(records[:60])
        return feature_dict


class ExplainableFeatureExtractor(BaseFeatureExtractor):
    def getExtraFeat(self, records):
        self.records_ma = records[:, self._fieldMap['ma']]
        self.records_ex = records[:, self._fieldMap['exchange']]
        self.records_ltsz = records[:, self._fieldMap['ltsz']]
        self.records_zjlr = records[:, self._fieldMap['zjlr']]
        self.records_ydjl = records[:, self._fieldMap['ydjl']]
        self.records_szdata = records[:, self._fieldMap['szdata']]
        feat_dict = {}
        for attr in dir(self):
            if 'subFunc' in attr:
                func = getattr(self, attr)
                if func():
                    key = func.__doc__#.decode("utf-8")
                    feat_dict[key] = True
        return feat_dict


    def subFunc1(self):
        '''短线强势,duanXianQiangShi'''
        if (_Grandient(self.records_ex, 0, 20, 20, 20) <= 1 \
                and (_CountDaysShangshenTongDao(self.records_ma, 1) > 0) \
                and (_Grandient(self.records_ma, 0, 60, 3, 3) > 0.3) \
                and (_Grandient(self.records_ex, 0, 10, 10, 10) < 0) \
                and (_Grandient(self.records_ma, 0, 0, 1, 5) < 0)):
            return True

