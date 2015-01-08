#! /usr/bin/python
# -*- coding: utf-8 -*-

import sys
import numpy as np
import random


__all__ = [
    'TransFeatFromFloats',
    'Mean',
    'Grandient',
    'GradientAngle',
    'ConNum',
    'ContinousIncrease',
    'PairsIncrease',
    'CoutNonNeg',
    'GradientsBySample',
    'ConinousPotiveCount',
    'GenRate',
    'HoriCmp',
    'VehiCmp',
    'Variance',
    'CountDaysShangshenTongDao',
    'GradMaxMin',
]


def TransFeatFromFloats(featname, feats):
    '''
    translate featnames into format: featurename_idx
    '''
    return ["%s_%d:%f" % (featname, idx, feats[idx]) for idx in range(len(feats))]


def Mean(records, beg, length):
    '''
    mean value of values in the records
    '''
    return np.mean(records[beg : beg + length])


def Grandient(records, cur, prev, frame_size=1, prev_frame_size=1):
    '''
    Grandient(cur_pos, prev_pos, frame_size, prev_frame_size)
    = ( Mean(c,f) - Mean(p,pf) ) / Mean(p,pf)
    '''
    cur_val = Mean(records, cur, frame_size)
    pre_val = Mean(records, prev, prev_frame_size)
    if (pre_val == 0) :
        pre_val += 0.000001
    return (cur_val - pre_val) / pre_val


def GradientAngle(records, cur, prev, frame_size=1, prev_frame_size=1):
    '''
    the angle value of gradient : when Gradient>1, it increases too quick

    '''
    return np.arctan(Gradient(record, cur, prev, frame_size, prev_frame_size))

    
def ConNum(records, li):
    '''
    ConNum(list) : continus increaseNum of [1, 3, 5, 10, 20 ...]
    '''
    res = 0
    for idx in range(len(li) - 1):
        cur = Mean(records, 0, li[idx])
        prev = Mean(records, 0, li[idx + 1])
        if cur < prev:
            res += 1
        else:
            break
    return res


def ContinousIncrease(records, li, thres):
    '''
    return 1 of 0 if the list is continously increase
    '''
    for idx in range(len(li)):
        if Grandient(records, idx, 1, idx+1, 1) < thres:
            return 0
    return 1


def PairsIncrease(records, pairs):
    '''
    return True if records increase for all pair in pairs
    '''
    for a,b in pairs:
        if records[a] < records[b]:
            return False
    return True


def CoutNonNeg(records, n):
    '''
    number of non negtive records in N
    '''
    filtered_records = filter(lambda item: item>=0, records[:n])
    return len(filtered_records)


def GradientsBySample(records, sample_rate):
    '''
    gradients of records sample by sample_rate
    '''
    sample_records = [Mean(records, idx*sample_rate, sample_rate) \
            for idx in range(len(records)/sample_rate)]

    sample_gradient = []

    for idx in range(len(sample_records) - 1):
        for idy in range(idx + 1, len(sample_records)):
            sample_gradient.append(Grandient(sample_records ,idx ,idy))

    mean_value = np.mean(sample_records)

    sample_gradient.append(sum(pow(sample_records - mean_value, 2)))

    return np.asarray(sample_gradient)
        

def ConinousPotiveCount(records):
    res = 0
    for item in records:
        if item > 0:
            res += 1
        else:
            break
    return res


def GenRate(records):
    '''
    todo
    '''
    gradient_list = [Grandient(records, idx, idx+1, 1, 1) > 0 for idx in range(len(records) - 1)]
    freq_list = []
    pre = None
    for idx in range(len(gradient_list) - 1):
        idn = idx + 1
        if not(gradient_list[idx] and gradient_list): # gradient's sign changes
            cur = idx
            if pre != None:
                freq_list.append(cur - pre)
            pre = cur
    if len(feaList) == 0:
        return 0
    return Mean(feaList)


def HoriCmp(records, ma_list, beg_pos):
    '''
    todo
    '''
    for [cur, prev] in ma_list:
        if Mean(records, beg_pos, cur) < Mean(records, beg_pos, prev):
            return 0
    return 1


def VehiCmp(records, big_window, small_window):
    '''
    todo
    '''
    for beg_pos in range(big_window):
        eng_pos = beg_pos + small_window
        if records[beg_pos] < records[eng_pos]:
            return 0
    return 1


def Variance(records):
    '''
    方差
    '''
    mean_value = Mean(records, 0, 10)
    variance = sum(np.power(records - mean_value, 2)) / len(records)
    variance = np.sqrt(variance)
    return variance


def CountDaysShangshenTongDao(records, window_size):
    '''
    上升通道
    todo
    '''
    # (ma5>ma20 and ma10>ma20 and ma20>ma30 and ma30>ma60)
    ma_list = [[5,20], [10,20], [20,30], [30,60]]
    return sum([HoriCmp(records, ma_list, beg) for beg in range(window_size)])


def GradMaxMin(records, beg, length, span=1):
    '''
    获取梯度MAX MIN
    '''
    max_gradient = -1
    min_gradient = 1
    for pos in range(beg, beg+length, span):
        next_pos = pos + span
        grad = Grandient(records, pos, next_pos, span, span)
        if grad > max_gradient:
            max_gradient = grad
        if grad < min_gradient:
            min_gradient = grad
    return (max_gradient, min_gradient)



