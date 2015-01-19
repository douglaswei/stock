from stockit.data import PrepareReocrds, StockRecordData, RecordsSampler, Unifoimer, FeatTranslator, IDFeatTranslator
from stockit.featExtractor import KnnFeatureExtractor, LrFeatureExtractor
from stockit.knn import v_main, collectInfo
from stockit.lr import BaseLr
from stockit.label import labelGenerate
from stockit.common import config

import logging 
logging.basicConfig(level=logging.DEBUG, filename='log')

PrepareReocrds().merge()
import pickle
import time

StockRecordData().extractFeatures([LrFeatureExtractor('test'),], labelGenerate)

RecordsSampler().sample('test_train', 'test_train_sample')

Unifoimer().uniform(['test_train_sample', 'test_test'], ['test_train_sample_uniform', 'test_test_uniform'])

FeatTranslator().translate('test_train_sample_uniform', 'lr_train', 3)
FeatTranslator().translate('test_test_uniform', 'lr_test', 3)

v_main()

collectInfo('knn_output', 'knn_info')

data = BaseLr(config())
data.prepareData()
data.run()
