#! /usr/bin/python

import sys
import os
from stockData import StockRecordsData
from stockExplainData import LrFeatureExtractor, KnnFeatureExtractor, ExplainableFeatureExtractor


if __name__ == '__main__':
    recordsData = StockRecordsData(sys.argv[1], sys.argv[2], 250, 5, 0.3, -0.3)
    recordsData.generateFeatures([
            LrFeatureExtractor('data/lr'),
            KnnFeatureExtractor('data/knn'),
            ExplainableFeatureExtractor('data/explain'),
            ])
