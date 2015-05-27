from stockit.model.DT import DT

__author__ = 'wgz'

import sys
from stockit.Common import load_data, discreate_feats, merge_results
from stockit.model import Knn
from stockit.model.LR import LR
from stockit.FeatManager import FeatManager

if __name__ == "__main__":
    # train_raw_data, train_data = load_data("test_train", 3)
    # predict_raw_data, predict_data = load_data("test_predict", 3)
    #
    # knn = Knn([20, 30, 50], train_data, predict_data, "res")
    # knn.execute()


    # feat_manager = FeatManager()
    # feat_manager.extract('feats', 'test_train_feats', 'test_predict_feats')

    # feat_manager.extract_discrete_feat('feats', 'test_train_feats', 'test_predict_feats', 3, 1000)
    # sys.exit(0)

    lr = LR('lr', '/Users/wgz/proj/liblinear-1.96/')
    lr.train_and_predict('/Users/wgz/proj/stock/featProcess/test_LR', '/Users/wgz/proj/stock/featProcess/feats')

    dt = DT()
    dt.train_pedict('/Users/wgz/proj/stock/featProcess/test_DT', '/Users/wgz/proj/stock/featProcess/feats')

    merge_results(['/Users/wgz/proj/stock/featProcess/test_LR/predict_result', '/Users/wgz/proj/stock/featProcess/test_DT/predict_result'], 'predict_result')
