import sys
from stockit.preprocess import DBDataToPickle
from stockit.featProcessor import FeatProcessor
from stockit.featExtractor import AdvancedFeatureExtractor
from stockit.featExtractor import KnnFeatureExtractor
from stockit.featExtractor import LrFeatureExtractor
from stockit.knn import v_main, collectInfo
from stockit.lr import BaseLr
from stockit.label import labelGenerate
from stockit.common import config
from stockit.data import Uniformer, IDFeatTranslator

import logging 
logging.basicConfig(level=logging.DEBUG, filename='log')

import pickle
import time



def tt_model():
    Uniformer().uniform(['lr/feat_lr_train', 'lr/feat_lr_test'],
            ['lr/feat_lr_train_uniform', 'lr/feat_lr_test_uniform'])
    feat_trans = IDFeatTranslator()
    feat_trans.translate('lr/feat_lr_train_uniform', 'lr/feat_train', 3)
    feat_trans.translate('lr/feat_lr_test_uniform', 'lr/feat_test', 3)


db_data = DBDataToPickle()
db_data = DBDataToPickle()
#db_data.generate_records()
lr_extractor = LrFeatureExtractor('lr/feat_lr')
feat_processor = FeatProcessor()
feat_processor.extractFeatures(lr_extractor, labelGenerate)
tt_model()




'''
StockRecordData().extractFeatures([LrFeatureExtractor('knn/test'),], labelGenerate)

RecordsSampler().sample('knn/test_train', 'knn/test_train_sample')

Unifoimer().uniform(['knn/test_train_sample', 'knn/test_test'], ['knn/test_train_sample_uniform', 'knn/test_test_uniform'])

FeatTranslator().translate('knn/test_train_sample_uniform', 'knn/knn_train', 3)
FeatTranslator().translate('knn/test_test_uniform', 'knn/knn_test', 3)

v_main()

collectInfo('knn/knn_output', 'knn/knn_info')

sys.exit(0)

data = BaseLr(config())
data.prepareData()
data.run()
'''
