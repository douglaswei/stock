#! /usr/bin/python

import sys
from stockData import StockPickleData

StockPickleData.saveAsPickle(sys.argv[1], sys.argv[2])
