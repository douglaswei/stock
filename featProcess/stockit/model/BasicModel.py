__author__ = 'wgz'

import numpy as np

from ..Common import load_data


class BasicModel:
    def __init__(self, name):
        self.name = name
        pass

    def load_features(self, fname):
        raw_features, np_recordes = load_data(fname, 3)
        labels = np.asarray([float(item[0].split(':')[1]) for item in raw_features])
        return raw_features, np_recordes, labels

    def train_and_predict(self, train_feature_fname, predict_feature_fname, output_fname):
        train_raw_feats, train_np_feats, train_labels = self.load_features(train_feature_fname)
        predict_raw_feats, predict_np_feats, predict_labels = self.load_features(predict_feature_fname)

        model = self.train(train_np_feats, train_labels)
        train_res = self.predict(model, train_np_feats)
        predict_res = self.predict(model, predict_np_feats)
        self.save_result(train_res, predict_res, output_fname)
        pass

    def train(self, train_feats, label):
        # return model
        pass

    def predict(self, model, feats):
        # return predict res
        pass

    def save_result(self, train_raw_feats, train_feats, train_labels, train_res, predict_raw_feats, predict_feats,
                    predict_res, output_fname):
        pass