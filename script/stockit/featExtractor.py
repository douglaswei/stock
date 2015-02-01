#! /usr/bin/py
# -*- coding: utf-8 -*-

import os
import sys
import pickle
import numpy as np
import logging

from function import *

__all__ = [
    'KnnFeatureExtractor',
    'LrFeatureExtractor',
    'ExplainableFeatureExtractor',
]

def safe_rm_file(fname):
    try:
        os.remove(fname)
    except Exception,e:
        logging.info('file:[%s] not exist' % fname)


class BaseFeatureExtractor(object):
    def __init__(self, file_prefix):
        self.train_filename = file_prefix + "_train"
        self.test_filename = file_prefix + "_test"
        safe_rm_file(self.train_filename)
        safe_rm_file(self.test_filename)


    def process(self, is_train, label, records_feat, lock):
        code = records_feat[0].code
        cdate = records_feat[0].cdate.strftime('%Y%m%d')
        logging.debug('process: [%s][%s][%s]' % (str(is_train), str(label),str(records_feat)))
        feats = self.processRecords(records_feat)
        
        fname = self.train_filename
        if not is_train:
            fname = self.test_filename
            label = 0
        
        lock.acquire()
        fout = open(fname, 'a')
        fout.write('%s\t%s\t%f\t%s\n' % (code, cdate, label, '\t'.join(feats)))
        fout.close()
        lock.release()

    
    def processRecords(self, records):
        # lable 为None, 测试数据，输出到测试文件
        res_features = []

        for attr in dir(records[0]):
            func_name = 'get_feat_%s' % attr
            func = getattr(self, func_name, None)
            if func is None:
                continue
            logging.debug('function for [%s] found:[%s]' % (attr, func_name))
            sub_records = [getattr(record, attr) for record in records]
            feat_dict = func(np.asarray(sub_records))
            if feat_dict is not None:
                res_features.extend(["%s:%f" % (k,v) for k,v in feat_dict.items()])
        feat_dict = self.getExtraFeat(records)
        if feat_dict is not None and len(feat_dict) > 0:
            feats = sorted(["%s:%s" % (k,str(v)) for (k,v) in feat_dict.items()])
            res_features.append('explain_feat:%d' % len(feats))
            res_features.extend(feats)

        # res_features
        # format k1:v1\tk2:v2...

        return res_features
        

    def get_feat_ma(self, records):
        pass


    def get_feat_exchange(self, records):
        pass


    def getExtraFeat(self, full_records):
        pass


class AdvancedFeatureExtractor(BaseFeatureExtractor):
    def get_feat_ma(self, records):
        return {}


    def get_feat_exchange(self, records):
        return {
            # 5天换手率的变化率
            'ex_gradient_0_5_5_5' : Gradient(records, 0, 5, 5, 5),
            # 10天换手率的变化率
            'ex_gradient_0_10_10_10' : Gradient(records, 0, 10, 10, 10),
            # 20天换手率的变化率
            'ex_gradient_0_20_20_20' : Gradient(records, 0, 20, 20, 20),
            # 5_100天换手率的变化率
            'ex_gradient_0_100_100_100' : Gradient(records, 0, 0, 5, 100),
        }

    
    def b_get_latest(self, name, records):
        return {
            '%s_mean_%d' % (name, 1) : records[0],
            '%s_mean_%d' % (name, 3) : Mean(records, 0, 3),
        }

    
    def b_get_range(self, name, records):
        return {
            '%s_variance_%d' % (name, 5) : Variance(records[:5]),
            '%s_gradient_%d_%d' % (name, 5, 3) : GradientAngle(records, 0, 5, 3, 3),
            '%s_gradient_%d_%d' % (name, 10, 3) : GradientAngle(records, 0, 10, 3, 3),
        }


    def b_simple(self, name, records):
        return {
            '%s_simple' % name : records[0],
        }


    def get_feat_ddx(self, records):
        return self.b_get_latest('ddx', records)


    def get_feat_ddy(self, records):
        return self.b_get_latest('ddy', records)


    def get_feat_ddz(self, records):
        return self.b_get_latest('ddz', records)


    def get_feat_net(self, records):
        return self.b_get_latest('net', records)


    def get_feat_xlarge_vol(self, records):
        return self.b_get_latest('xlarge_vol', records)


    def get_feat_large_vol(self, records):
        return self.b_get_latest('large_vol', records)

    
    def get_feat_normal_vol(self, records):
        return self.b_get_latest('normal_vol', records)


    def get_feat_small_vol(self, records):
        return self.b_get_latest('small_vol', records)

    def get_feat_strength(self, records):
        return self.b_get_latest('strength', records)

    def get_feat_active_rate(self, records):
        return self.b_get_latest('active_rate', records)

    def get_feat_take_rate(self, records):
        return self.b_get_latest('take_rate', records)

    def get_feat_xlarge_percent(self, records):
        return self.b_get_latest('xlarge_percent', records)

    def get_feat_large_percent(self, records):
        return self.b_get_latest('large_percent', records)

    def get_feat_normal_percent(self, records):
        return self.b_get_latest('normal_percent', records)

    def get_feat_small_percent(self, records):
        return self.b_get_latest('small_percent', records)

    def get_feat_activity(self, records):
        return self.b_get_latest('activity', records)

    def get_feat_danshu_ratio(self, records):
        return self.b_get_latest('danshu_ratio', records)

    def get_feat_ddx5(self, records):
        return self.b_get_latest('ddx5', records)

    def get_feat_ddy5(self, records):
        return self.b_get_latest('ddy5', records)

    def get_feat_ddx60(self, records):
        return self.b_get_latest('ddx60', records)

    def get_feat_ddy60(self, records):
        return self.b_get_latest('ddy60', records)

    def get_feat_ddx10_red(self, records):
        return self.b_get_latest('ddx10_red', records)

    def get_feat_ddx10_con(self, records):
        return self.b_get_latest('ddx10_con', records)

    def get_feat_xiao_dan_cha_shou(self, records):
        return self.b_get_latest('xiao_dan_cha_shou', records)

    def get_feat_zi_jin_qiang_du(self, records):
        return self.b_get_latest('zi_jin_qiang_du', records)

    def get_feat_in_danshu(self, records):
        return self.b_get_latest('in_danshu', records)

    def get_feat_out_danshu(self, records):
        return self.b_get_latest('out_danshu', records)

    def get_feat_in_avg_shou(self, records):
        return self.b_get_latest('in_avg_shou', records)

    def get_feat_out_avg_shou(self, records):
        return self.b_get_latest('out_avg_shou', records)

    def get_feat_xiao_dan_leiji(self, records):
        return self.b_get_latest('xiao_dan_leiji', records)

    def get_feat_jin_e_lei_ji(self, records):
        return self.b_get_latest('jin_e_lei_ji', records)

    def get_feat_xlarge_in(self, records):
        return self.b_get_latest('xlarge_in', records)

    def get_feat_xlarge_out(self, records):
        return self.b_get_latest('xlarge_out', records)

    def get_feat_large_in(self, records):
        return self.b_get_latest('large_in', records)

    def get_feat_large_out(self, records):
        return self.b_get_latest('large_out', records)

    def get_feat_normal_in(self, records):
        return self.b_get_latest('normal_in', records)

    def get_feat_normal_out(self, records):
        return self.b_get_latest('normal_out', records)

    def get_feat_small_in(self, records):
        return self.b_get_latest('small_in', records)

    def get_feat_small_out(self, records):
        return self.b_get_latest('small_oout', records)

    def get_feat_liang_bi(self, records):
        return self.b_get_latest('liang_bi', records)

    def get_feat_pe_ratio(self, records):
        return self.b_get_latest('pe_ratio', records)

    def get_feat_pe_ps(self, records):
        return self.b_get_latest('pe_ps', records)


    def getExtraFeat(self, full_records):
        return {}


class KnnFeatureExtractor(AdvancedFeatureExtractor):
    def get_feat_ma(self, records):
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
            'ma_gradient_0_5_3_3' : GradientAngle(records, 0, 5, 3, 3),
            # 10天ma3涨幅
            'ma_gradient_0_10_3_3' : GradientAngle(records, 0, 10, 3, 3),
            # 20天ma3涨幅
            'ma_gradient_0_20_3_3' : GradientAngle(records, 0, 20, 3, 3),
            # 30天ma5涨幅
            'ma_gradient_0_30_5_5' : GradientAngle(records, 0, 30, 5, 5),
            # 50天ma5涨幅
            'ma_gradient_0_50_5_5' : GradientAngle(records, 0, 50, 5, 5),
            # 100天ma10涨幅
            #'ma_gradient_0_100_10_10' : GradientAngle(records, 0, 100, 10, 10),
            # ma1_ma5涨幅
            'ma_gradient_0_0_1_5' : GradientAngle(records, 0, 0, 1, 5),
            # ma1_ma10涨幅
            'ma_gradient_0_0_1_10' : GradientAngle(records, 0, 0, 1, 10),
            # ma1_ma30涨幅
            'ma_gradient_0_0_1_30' : GradientAngle(records, 0, 0, 1, 30),
            # ma1_ma60涨幅
            'ma_gradient_0_0_1_60' : GradientAngle(records, 0, 0, 1, 60),
            # ma1_ma100涨幅
            'ma_gradient_0_0_1_100' : GradientAngle(records, 0, 0, 1, 100),
            # 10天在处于上升通道的天数
            'ma_cout_increase_days_10' : CountDaysShangshenTongDao(records, 10),
            # 30天在处于上升通道的天数
            'ma_cout_increase_days_30' : CountDaysShangshenTongDao(records, 30),
            # 60天在处于上升通道的天数
            'ma_cout_increase_days_60' : CountDaysShangshenTongDao(records, 60),
        }


class LrFeatureExtractor(AdvancedFeatureExtractor):
    def get_feat_ma(self, records):
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
        records_ma = np.asarray([getattr(record, 'ma') for record in records])
        records_ex = np.asarray([getattr(record, 'exchange') for record in records])
        feat_dict = {}
        for attr in dir(self):
            if 'subFunc' in attr:
                func = getattr(self, attr)
                value = func(records_ma,
                        records_ex)
                if value:
                    key = func._doc__
                    feat_dict[key] = value
        return feat_dict


    def subFunc1(self,
            records_ma,
            records_ex):
        '''短线强势,duanXianQiangShi'''
        if (Gradient(records_ex, 0, 20, 20, 20) >= 1 \
                and (CountDaysShangshenTongDao(records_ma, 1) > 0) \
                and (Gradient(records_ma, 0, 20, 3, 3) < 0.15) \
                and (Gradient(records_ma, 0, 10, 3, 3) < 0.1) \
                and (Gradient(records_ex, 0, 10, 10, 10) > 0)):
            return True


    def subFunc2(self,
            records_ma,
            records_ex):
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
            records_ex):
        '''持续平稳,chiXuPingWen'''
        if ((GradRange(records_ma, 0, 30, 1)[0] < 0.03) \
                and (GradRange(records_ma, 0, 30, 1)[1] > -0.03) \
                and (Gradient(records_ma, 0, 60, 3, 3) < 0.3) \
                and (Gradient(records_ma, 0, 100, 3, 3) < 0.5)):
            return True

