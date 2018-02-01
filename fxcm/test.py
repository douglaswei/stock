# -*- coding: utf-8 -*-
__author__ = 'wgz'


from prepare.parse import *
from prepare.traverse import Traverser


process_data_dir("/Users/wgz/proj/stock/fxcm/data", "/Users/wgz/proj/stock/fxcm/data", "2008-01-01 00:00",
                 "2018-01-29 00:00")


# trav = Traverser("/Users/wgz/proj/stock/fxcm/data", "EURUSD", ".csv")
# for features in trav.traverse(3):
#   print features

import tensorflow as tf
tf.nn.conv1d()