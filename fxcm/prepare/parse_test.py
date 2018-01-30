# -*- coding: utf-8 -*-
__author__ = 'wgz'


from parse import *

if __name__ == "__main__":
  # parse_hst_csv("/Users/wgz/Downloads/EURUSD5.hst", "/Users/wgz/proj/stock/fxcm/5m", "2008-01-01 00:00", "2018-01-29 "
  #                                                                                                        "00:00")

  process_data_dir("/Users/wgz/proj/stock/fxcm/data", "/Users/wgz/proj/stock/fxcm/data", "2008-01-01 00:00", "2018-01-29 00:00")