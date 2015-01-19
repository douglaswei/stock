#! /usr/bin/python
# coding:utf-8

import sys
import os
import gc
import pickle
import numpy as np
import sklearn as sk
import common

def labelGenerate(label_records, config):
    ma_idx = common.recordsFiledMap['ma']
    ma_records = label_records[:,ma_idx]
    cur_ma = ma_records[-1]
    next_ma = np.mean(ma_records[:-1])
    gradient = (next_ma - cur_ma) / cur_ma

    if gradient > -0.05 and gradient < 0.05:
        return None
    return gradient

    if max_gradient < 0.1 and min_gradient < 0 and min_gradient < self.__config.lower_thredhold:
        return round(min_gradient, 4)

    if max_gradient > self.__config.upper_threohold:
        return round(max_gradient, 4)


    

def gecodeLabel01(label):
    if isinstance(label, str):
        label = float(label)
    if label > 0:
        return 1
    return -1

def gecodeLabelN(label):
    return None
