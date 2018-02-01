# -*- coding: utf-8 -*-
__author__ = 'wgz'

import os
import pandas as pd
from process.process import ma_wrapper, macd, kdj, rsi, adx


class Traverser():

  def __init__(self, path, item_name, path_suffix='.csv'):
    self.dfs = {}
    self.path = path
    self.item_name = item_name.upper()
    self.path_prefix = os.path.sep.join([self.path, self.item_name])
    self.path_suffix = path_suffix
    self.time_cfg = sorted([1440, 240, 60, 30, 15, 5])
    self.load_files()

  def load_files(self):
    """
    预加载所有数据文件
    """
    for item_time in self.time_cfg:
      file_path = ''.join([self.path_prefix, str(item_time), self.path_suffix])
      self.dfs[item_time] = pd.read_csv(file_path, index_col="time")
      # 补充其他数据 比如macd等

    for key, df in self.dfs.items():
      ma_wrapper(df, 5)
      ma_wrapper(df, 10)
      ma_wrapper(df, 20)
      if key >= 30:
        macd(df)
        kdj(df)
        rsi(df, 6)
        rsi(df, 12)
        rsi(df, 14)
        adx(df)
    print df

  def traverse(self, slot_num=30, cal_last_upper_flag=True):
    """
    遍历
    :param cal_last_upper_flag: 对于最后一列未完成的数据，是否计算后填充
    :param slot_num: 需要的数据序列大小
    """
    features = []
    # 获取当前的最后的时间戳， 比如 5min粒度 "2018-01-29 12:05:00"
    # last_time = None if time_flag_idx == 0 else features[-1][-1].time

    # 根据5min粒度的最后时间戳 获取下一粒度的特征序列

    # 对于5min序列遍历， 然后对根据当前5min序列，计算大粒度的序列
    # 优化：对于5min 序列，直接+天数*slot_num
    beg_time = self.dfs[self.time_cfg[-1]].iloc[slot_num].name
    for res in self.get_feature(beg_time, None, slot_num, 0):
      features = [res, ]
      for time_flag_idx in range(1, len(self.time_cfg)):
        for feature in self.get_feature(None, features[0][0][0], slot_num, time_flag_idx):
          if len(feature) < slot_num:
            break
          while len(features) > time_flag_idx:
            features.pop()
          features.append(feature)
          if len(features) == len(self.time_cfg):
            yield features

  def get_feature(self, beg_time, end_time, slot_num, time_flag_idx):
    """
    返回[beg_time, end_time] 闭包的特征集
    :param beg_time:
    :param end_time:
    :param slot_num:
    :param time_flag_idx:
    """
    time_flag = self.time_cfg[time_flag_idx]
    df = self.dfs[time_flag][beg_time:end_time]
    if time_flag_idx != 0:
      # 高阶时间戳，需要丢弃最后一个元素
      yield df[:-1].tail(slot_num).reset_index().values
    else:
      # 可以从闭包做区间开始遍历
      for idx in range(0, df.shape[0] - slot_num):
        yield df[idx:idx + slot_num].reset_index().values


if __name__ == '__main__':
  pd.set_option('display.height', 1000)
  pd.set_option('display.max_rows', 500)
  pd.set_option('display.max_columns', 500)
  pd.set_option('display.width', 1000)

  trav = Traverser("/Users/wgz/proj/stock/fxcm/data", "EURUSD", ".csv")
  for features in trav.traverse(40):
    print features
