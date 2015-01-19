#! /usr/bin/py
# -*- coding: utf-8 -*-

import os
import sys
import pickle
import numpy as nu
import threading
from Queue import Queue

from function import *

__all__ = [
    'KnnFeatureExtractor',
    'LrFeatureExtractor',
    'ExplainableFeatureExtractor',
]

class BaseFeatureExtractor(object):
    fieldMap = {
            'ma' : 0,
            'ma_gradient' : 1,
            'exchange_rate' : 2,
            'ltsz' : 3,
            'zjlr' : 4,
            'ydjl' : 5,
            }


    def __init__(self, file_prefix, thread_num=4):
        self.train_filename = file_prefix + "_train"
        self.trainfile = open(self.train_filename, 'w')
        self.test_filename = file_prefix + "_test"
        self.testfile = open(self.test_filename, 'w')
        self.thread_num = thread_num
        self.q = Queue()
        self.lock = threading.RLock()
        self.thds = []
        for i in range(thread_num):
            thd = threading.Thread(target=self.getRecords)
            self.thds.append(thd)
            thd.start()
        

    def __del__(self):
        if self.trainfile is not None:
            self.trainfile.close()
        if self.testfile is not None:
            self.testfile.close()

        for thd in self.thds:
            if thd.isAlive():
                self.q.put(None)

    
    def putRecords(self, *args):
        self.q.put(args)


    def getRecords(self):
        while True:
            args = self.q.get()
            if args is None:
                return
            self.processRecords(*args)


    def finish(self):
        for i in range(self.thread_num):
            self.q.put(None)
        for thd in self.thds:
            thd.join()


    def processRecords(self, records, code, date, label=None):
        # lable 为None, 测试数据，输出到测试文件
        fout = self.trainfile
        if label is None:
            label = 0
            fout = self.testfile

        if fout is None:
            return

        res_features = []
        func_dict = {
            'ma' : self.getMaFeatures,
            'exchange_rate' : self.getExchangeFeatures,
            'ltsz' : self.getLtszFeatures,
            'zjlr' : self.getZjlrFeatures,
            'ydjl' : self.getYdjlFeatures,
        }
        for key, func in func_dict.items():
            feat_dict = func(records[:, self.fieldMap[key]])
            if feat_dict is not None:
                res_features.extend(["%s:%f" % (k,v) for k,v in feat_dict.items()])
        feat_dict = self.getExtraFeat(records)
        if feat_dict is not None and len(feat_dict) > 0:
            feats = sorted(["%s:%s" % (k,str(v)) for (k,v) in feat_dict.items()])
            res_features.append('explain_feat:%d' % len(feats))
            res_features.extend(feats)

        # res_features
        # format k1:v1\tk2:v2...

        self.lock.acquire()
        fout.write(code + '\t' + date + '\t' + str(label))
        for feat in res_features:
            fout.write('\t' + feat)
        fout.write('\n')
        self.lock.release()
        

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


class AdvancedFeatureExtractor(BaseFeatureExtractor):
    def getMaFeatures(self, records):
        return {}


    def getExchangeFeatures(self, records):
        return {
            # 5天换手率的变化率 * 100
            'ex_gradient_0_5_5_5' : Gradient(records, 0, 5, 5, 5),
            # 10天换手率的变化率 * 100
            'ex_gradient_0_10_10_10' : Gradient(records, 0, 10, 10, 10),
            # 20天换手率的变化率 * 100
            'ex_gradient_0_20_20_20' : Gradient(records, 0, 20, 20, 20),
            # 5_100天换手率的变化率 * 100
            'ex_gradient_0_100_100_100' : Gradient(records, 0, 0, 5, 100),
        }


    def getLtszFeatures(self, records):
        return {
            'ltsz_grad_0_5_5_5' : Gradient(records, 0, 5, 5, 5),
            'ltsz_variance_10' : Variance(records[:10]),
            'ltsz_variance_20' : Variance(records[:20]),
            'ltsz_variance_30' : Variance(records[:30]),
            'ltsz_variance_60' : Variance(records[:60]),
        }


    def getZjlrFeatures(self, records):
        return {
            'zjlr_grad_0_5_5_5' : Gradient(records, 0, 5, 5, 5),
            'zjlr_postive_num_5' : CoutNonNeg(records, 5),
            'zjlr_postive_num_10' : CoutNonNeg(records, 10),
            'zjlr_variance_10' : Variance(records[:10]),
            'zjlr_variance_20' : Variance(records[:20]),
            'zjlr_variance_30' : Variance(records[:30]),
            'zjlr_variance_60' : Variance(records[:60]),
        }


    def getYdjlFeatures(self, records):
        return {
            'ydjl_grad_0_5_5_5' : Gradient(records, 0, 5, 5, 5),
            'ydjl_postive_num_5' : CoutNonNeg(records, 5),
            'ydjl_postive_num_10' : CoutNonNeg(records, 10),
            'ydjl_variance_10' : Variance(records[:10]),
            'ydjl_variance_20' : Variance(records[:20]),
            'ydjl_variance_30' : Variance(records[:30]),
            'ydjl_variance_60' : Variance(records[:60]),
        }


    def getSzdataFeatures(self, records):
        '''
        1. 最近10天的偏方差
        2. 最近10天涨幅
        '''
        return {
            "szdata_variance" : Variance(records[:10]),
            "szdata_gradient10" : Gradient(records, 0, 0, 3, 10),
            }


    def getExtraFeat(self, full_records):
        return {}


class KnnFeatureExtractor(AdvancedFeatureExtractor):
    def getMaFeatures(self, records):
        '''
        '''
        return {
            # 5天方差
            'ma_variance_5' : Variance(records[:5]),
            # 10天方差
            'ma_variance_10' : Variance(records[:10]),
            # 20天方差
            'ma_variance_20' : Variance(records[:20]),
            # 30天方差
            'ma_variance_30' : Variance(records[:30]),
            # 60天的方差
            'ma_variance_60' : Variance(records[:60]),
            # 5天ma3涨幅
            'ma_gradient_0_5_3_3' : Gradient(records, 0, 5, 3, 3),
            # 10天ma3涨幅
            'ma_gradient_0_10_3_3' : Gradient(records, 0, 10, 3, 3),
            # 20天ma3涨幅
            'ma_gradient_0_20_3_3' : Gradient(records, 0, 20, 3, 3),
            # 30天ma5涨幅
            'ma_gradient_0_30_5_5' : Gradient(records, 0, 30, 5, 5),
            # 60天ma5涨幅
            'ma_gradient_0_60_5_5' : Gradient(records, 0, 60, 5, 5),
            # 100天ma10涨幅
            'ma_gradient_0_100_10_10' : Gradient(records, 0, 100, 10, 10),
            # 230天ma10涨幅
            'ma_gradient_0_230_10_10' : Gradient(records, 0, 230, 10, 10),
            # ma1_ma5涨幅
            'ma_gradient_0_0_1_5' : Gradient(records, 0, 0, 1, 5),
            # ma1_ma10涨幅
            'ma_gradient_0_0_1_10' : Gradient(records, 0, 0, 1, 10),
            # ma1_ma30涨幅
            'ma_gradient_0_0_1_30' : Gradient(records, 0, 0, 1, 30),
            # ma1_ma60涨幅
            'ma_gradient_0_0_1_60' : Gradient(records, 0, 0, 1, 60),
            # ma1_ma100涨幅
            'ma_gradient_0_0_1_100' : Gradient(records, 0, 0, 1, 100),
            # 10天在处于上升通道的天数
            'ma_cout_increase_days_10' : CountDaysShangshenTongDao(records, 10),
            # 30天在处于上升通道的天数
            'ma_cout_increase_days_30' : CountDaysShangshenTongDao(records, 30),
            # 60天在处于上升通道的天数
            'ma_cout_increase_days_60' : CountDaysShangshenTongDao(records, 60),
        }


class LrFeatureExtractor(AdvancedFeatureExtractor):
    def getMaFeatures(self, records):
        '''
        '''
        feature_dict = {}
        # [5,20],[10,20],[20,30],[30,60] 上升通道
        # 小窗口3、5、10、20天的所有梯度
        for sample_rate in [3, 10]:
            grads = GradientsBySample(records[:60], sample_rate, GradientAngle)
            for idx in range(len(grads)):
                key = 'ma_grad_%d_%d' % (sample_rate, idx)
                feature_dict[key] = grads[idx]

        # 60天10天为小窗口内上升通道天数
        for idx in range(6):
            key = 'ma_increase_count_%d' % idx
            feature_dict[key] = CountDaysShangshenTongDao(records[idx*10:], 10)
        # 10天方差
        feature_dict["ma_var_10"] = Variance(records[:10])
        # 20天方差
        feature_dict["ma_var_20"] = Variance(records[:20])
        # 30天方差
        feature_dict["ma_var_30"] = Variance(records[:30])
        # 60天方差
        feature_dict["ma_var_60"] = Variance(records[:60])
        return feature_dict


class ExplainableFeatureExtractor(BaseFeatureExtractor):
    def getExtraFeat(self, records):
        records_ma = records[:, self.fieldMap['ma']]
        records_ex = records[:, self.fieldMap['exchange_rate']]
        records_ltsz = records[:, self.fieldMap['ltsz']]
        records_zjlr = records[:, self.fieldMap['zjlr']]
        records_ydjl = records[:, self.fieldMap['ydjl']]
        #self.records_szdata = records[:, self.fieldMap['szdata']]
        feat_dict = {}
        for attr in dir(self):
            if 'subFunc' in attr:
                func = getattr(self, attr)
                value = func(records_ma,
                        records_ex,
                        records_ltsz,
                        records_zjlr,
                        records_ydjl)
                if value:
                    key = func._doc__#.decode("utf-8")
                    feat_dict[key] = value
        return feat_dict


    def subFunc1(self,
            records_ma,
            records_ex,
            records_ltsz,
            records_zjlr,
            records_ydjl):
        '''短线强势,duanXianQiangShi'''
        if (Gradient(records_ex, 0, 20, 20, 20) >= 1 \
                and (CountDaysShangshenTongDao(records_ma, 1) > 0) \
                and (Gradient(records_ma, 0, 20, 3, 3) < 0.15) \
                and (Gradient(records_ma, 0, 10, 3, 3) < 0.1) \
                and (Gradient(records_ex, 0, 10, 10, 10) > 0)):
            return True


    def subFunc2(self,
            records_ma,
            records_ex,
            records_ltsz,
            records_zjlr,
            records_ydjl):
        '''上升通道,shangShengTongDao'''
        if (Gradient(records_ex, 0, 100, 100, 100) > 0 \
                and (Gradient(records_ex, 0, 0, 100, 10) > 1) \
                and (CountDaysShangshenTongDao(records_ma, 1) > 0) \
                and (Gradient(records_ex, 0, 10, 10, 10) > 0) \
                and (Gradient(records_ma, 0, 0, 5, 5) < 0) \
                and (Gradient(records_ma, 0, 0, 5, 10) > 0) \
                and (Gradient(records_ma, 0, 0, 5, 10) < 0.03)):
            return True


    def subFunc3(self,
            records_ma,
            records_ex,
            records_ltsz,
            records_zjlr,
            records_ydjl):
        '''持续平稳,chiXuPingWen'''
        if ((GradRange(records_ma, 0, 30, 1)[0] < 0.03) \
                and (GradRange(records_ma, 0, 30, 1)[1] > -0.03) \
                and (Gradient(records_ma, 0, 60, 3, 3) < 0.3) \
                and (Gradient(records_ma, 0, 100, 3, 3) < 0.5)):
            return True

