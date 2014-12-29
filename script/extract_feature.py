#! /usr/bin/python

import sys
from stockData import FeatureData

if __name__ == "__main__":
    featData = FeatureData(100)
    featData.processTrainData(sys.argv[1], sys.argv[2])
    featData.processTestData(sys.argv[3], sys.argv[4])

