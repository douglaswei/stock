from stockit.data import PrepareReocrds, StockRecordData, RecordsSampler
from stockit.featExtractor import KnnFeatureExtractor

import logging 
logging.basicConfig(level=logging.DEBUG, filename='log')

#PrepareReocrds().merge()
import pickle
import time

data = StockRecordData()
data.extractFeatures([KnnFeatureExtractor('test'),])

#data = RecordsSampler()
#data.sample()

