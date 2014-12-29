#! /usr/bin/python
# -*- coding: utf-8 -*-

import sys
import numpy as nu

__all__ = [
    '_Mean',
    '_Grandient',
    '_ConNum',
    '_Pos',
    '_GradientsBySample',
    '_GradientsByList',
    '_ConinousPotiveCount',
    '_GenRate',
    '_ContinousInc',
    '_HoriCmp',
    '_VehiCmp',
    '_TransFeatFromFloats',
    '_Variance',
    '_CountDaysShangshenTongDao',
]

def _TransFeatFromFloats(featname, feats):
    return ["%s_%d:%f" % (featname, idx, feats[idx]) for idx in range(len(feats))]

# Mean(beg_pos, frame_size) : mean value of frame
def _Mean(records, beg, frame_size):
    return nu.mean(records[beg : beg + frame_size])


# Grandient(cur_pos, prev_pos, frame_size, prev_frame_size)
#   = ( Mean(c,f) - Mean(p,pf) ) / Mean(p,pf)
def _Grandient(records, cur, prev, frame_size, prev_frame_size):
    cur_val = _Mean(records, cur, frame_size)
    pre_val = _Mean(records, prev, prev_frame_size)
    if (pre_val == 0) :
        pre_val += 0.000001
    return (cur_val - pre_val) / pre_val

    
# ConNum(list) : continus increaseNum of [1, 3, 5, 10, 20 ...]
def _ConNum(records, li):
    res = 0
    for idx in range(len(li) - 1):
        cur = _Mean(records, 0, li[idx])
        prev = _Mean(records, 0, li[idx + 1])
        if cur < prev:
            res += 1
        else:
            break
    return res


# return 1 of 0 if the list is continously increase
def _ContinousInc(records, li, thres):
    for idx in range(len(li)):
        if _Grandient(records, idx, 1, idx+1, 1) < thres:
            return 0
    return 1


# Pos(N) : number of postive records in N
def _Pos(records, n):
    return sum([int(record > 0)for record in records[:n]])


def _GradientsBySample(records, sample_rate):
    sample_records = [_Mean(records, idx*sample_rate, sample_rate) \
            for idx in range(len(records)/sample_rate)]

    sample_gradient = []

    for idx in range(len(sample_records) - 1):
        for idy in range(idx + 1, len(sample_records)):
            sample_gradient.append(_Grandient(sample_records ,idx ,idy, 1, 1))

    mean_value = nu.mean(sample_records)

    sample_gradient.append(sum(pow(sample_records - mean_value, 2)))

    return nu.asarray(sample_gradient)
        

def _GradientsByList(records, window_list, big_window, sample_rate):
    gradient_list = []
    for pos in range(0, big_window, sample_rate):
        sample_records = [_Mean(records, pos, window) for window in window_list]

        for idx in range(len(sample_records)):
            for idy in range(idx + 1, len(sample_records)):
                gradient_list.append(cmp(sample_records[idx], sample_records[idy]))

    return nu.asarray(gradient_list)


def _ConinousPotiveCount(records):
    res = 0
    for item in records:
        if item > 0:
            res += 1
        else:
            break
    return res


def _GenRate(records):
    gradient_list = [_Grandient(records, idx, idx+1, 1, 1) > 0 for idx in range(len(records) - 1)]
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
    return _Mean(feaList)


def _HoriCmp(records, ma_list, beg_pos):
    for [cur, prev] in ma_list:
        if _Mean(records, beg_pos, cur) < _Mean(records, beg_pos, prev):
            return 0
    return 1


def _VehiCmp(records, big_window, small_window):
    for beg_pos in range(big_window):
        eng_pos = beg_pos + small_window
        if records[beg_pos] < records[eng_pos]:
            return 0
    return 1


def _Variance(records):
    '''方差'''
    mean_value = _Mean(records, 0, 10)
    variance = sum(nu.power(records - mean_value, 2))
    return variance


def _CountDaysShangshenTongDao(records, window_size):
    # (ma5>ma20 and ma10>ma20 and ma20>ma30 and ma30>ma60)
    ma_list = [[5,20], [10,20], [20,30], [30,60]]
    return sum([_HoriCmp(records, ma_list, beg) for beg in range(window_size)])

