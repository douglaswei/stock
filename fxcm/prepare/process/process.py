# -*- coding: utf-8 -*-
__author__ = 'wgz'

import sys
import pandas as pd
import numpy as np


def ma(series, N):
  shape = series.shape
  kernel = np.ones(N) / N
  result = np.convolve(series, kernel)[:shape[0]]
  return result


def ema(series, N):
  shape = series.shape
  N = float(N)
  p = 2 / (N + 1)
  p_m = 1 - p

  result = np.empty(shape[0])
  result[0] = series[0]
  for idx in range(1, shape[0]):
    result[idx] = result[idx - 1] * p_m + series[idx] * p
  return result


def ma_wrapper(df, N, name_pre="ma"):
  """
  ma wrapper

  :param df: dataframe
  :param N: n for ma, ema
  :param name_pre: string 'ma', 'ema'
  :return:
  """
  fn_obj = getattr(sys.modules[__name__], name_pre)
  name = name_pre + "_%d"
  name = name % N

  ma_series = fn_obj(df['close'], N)
  df.insert(len(df.columns), name, ma_series)
  return df


def macd(df):
  if 'ema_12' not in df.columns:
    ma_wrapper(df, 12, 'ema')

  if 'ema_26' not in df.columns:
    ma_wrapper(df, 26, 'ema')

  if 'diff' not in df.columns:
    diff = df['ema_12'] - df['ema_26']
    df.insert(len(df.columns), 'diff', diff)
  diff = df['diff']

  if 'dea' not in df.columns:
    dea = ma(diff, 9)
    df.insert(len(df.columns), 'dea', dea)
  dea = df['dea']

  if 'macd_bar' not in df.columns:
    macd_bar = diff - dea
    df.insert(len(df.columns), 'macd_bar', macd_bar)
  return df


def kdj(df, N=9):
  shape = df.shape[0]
  h = np.empty(shape)
  l = np.empty(shape)

  for idx in range(shape):
    beg = idx - N + 1
    beg = None if beg < 0 else beg
    end = idx + 1
    h[idx] = np.max(df['high'][beg:end])
    l[idx] = np.min(df['low'][beg:end])

  rsv = (df['close'] - l) * 100.0 / (h - l)
  k = np.empty(shape)
  d = np.empty(shape)

  k[0], d[0] = 50, 50

  for idx in range(1, shape):
    k[idx] = k[idx - 1] * 2 / 3 + rsv[idx] / 3
    d[idx] = d[idx - 1] * 2 / 3 + k[idx] / 3
  j = 3 * k - 2 * d
  df.insert(len(df.columns), 'k', k)
  df.insert(len(df.columns), 'd', d)
  df.insert(len(df.columns), 'j', j)
  return df


def rsi(df, N):
  name = "rsi_%d" % N
  pos = df['open'] < df['close']

  series = ma(pos.astype(float), N)
  df.insert(len(df.columns), name, series)
  return df


def adx(df):
  length = df.shape[0]
  ref_c = df['close']
  ref_c = pd.concat([pd.Series([ref_c[0], ]), ref_c], ignore_index=True)[:length]
  hd = df['high'] - ref_c
  ld = ref_c - df['low']
  mp = np.empty(length)
  dmp = np.empty(length)
  mm = np.empty(length)
  dmm = np.empty(length)
  tr_i = np.max([np.abs(hd), np.abs(ld), df['high'] - df['low']], axis=0)
  tr = np.empty(length)

  for i in range(length):
    mp[i] = hd[i] if hd[i] > 0 and hd[i] > ld[i] else 0
    mm[i] = ld[i] if ld[i] > 0 and ld[i] > hd[i] else 0

    beg = i - 13
    beg = None if beg < 0 else beg
    end = i + 1
    dmp[i] = np.sum(mp[beg:end])
    dmm[i] = np.sum(mm[beg:end])
    tr[i] = np.sum(tr_i[beg:end])

  pdi = dmp / tr
  dmi = dmm / tr

  ad = np.abs(pdi - dmi) / (pdi + dmi)
  adx_series = ma(ad, 14)

  df.insert(len(df.columns), 'pdi', pdi)
  df.insert(len(df.columns), 'dmi', dmi)
  df.insert(len(df.columns), 'adx', adx_series)
  return df


# test
#
# df = pd.read_csv("/Users/wgz/proj/stock/fxcm/data/EURUSD1440.csv")
# ma_wrapper(df, 5)
# ma_wrapper(df, 10)
# ma_wrapper(df, 15)
# # macd(df)
# kdj(df)
# # rsi(df, 5)
# # rsi(df, 10)
# # rsi(df, 14)
# adx(df)
# xx = df[:100]
# print xx
