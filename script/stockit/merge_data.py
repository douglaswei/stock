#! /usr/bin/py

import os
import sys
from stockData import StockRawData
 

if __name__ == "__main__":
    inputDir = sys.argv[1]
    outputRecordFile = sys.argv[2]
    outputCateFile = sys.argv[3]
    stockRawdata = StockRawData(inputDir)

    stockRawdata.merge(outputRecordFile, outputCateFile)
    

