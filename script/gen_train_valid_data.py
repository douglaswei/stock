#! /usr/bin/python

import sys
import os
import gc
from stockData import StockRecordsData
from stockExplainData import LrFeatureExtractor, KnnFeatureExtractor, ExplainableFeatureExtractor

def main(recordsFileName,
        cateFileName,
        featClassName,
        outFile,
        featWindow,
        labelWindow,
        upperThreshold,
        lowerThreshold):

    aClass = eval(featClassName)
    recordsData = StockRecordsData(
            recordsFileName,
            cateFileName,
            featWindow,
            labelWindow,
            upperThreshold,
            lowerThreshold)

    recordsData.generateFeatures([
            aClass(outFile),
            ])

    return


if __name__ == '__main__':
    recordsFileName = sys.argv[1]
    cateFileName = sys.argv[2]
    featClassName = sys.argv[3]
    outFile = sys.argv[4]
    featWindow = 250
    labelWindow = 10
    upperThreshold = 0.4
    lowerThreshold = -0.15
    main(recordsFileName,
            cateFileName,
            featClassName,
            outFile,
            featWindow,
            labelWindow,
            upperThreshold,
            lowerThreshold)
    #LrFeatureExtractor('data/lr'),
    #KnnFeatureExtractor('data/knn'),
    #ExplainableFeatureExtractor('data/explain'),
    sys.exit(0)

