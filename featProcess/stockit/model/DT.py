import gc
from sklearn.tree import DecisionTreeClassifier, export_graphviz
from stockit.FeatManager import FeatManager
import numpy as np

__author__ = 'wgz'


class DT():
    def set_param(self, work_path):
        if work_path[-1] != '/':
            work_path += '/'
        self.work_path = work_path
        self.feature_train = work_path + 'feat_train'
        self.feature_predict = work_path + 'feat_predict'
        self.model_path = work_path + 'model'
        self.validate_mid_path = work_path + 'validate_mid'
        self.predict_mid_path = work_path + 'predict_mid'

        self.validate_result_path = work_path + 'validate_result'
        self.predict_result_path = work_path + 'predict_result'

    def load_feature_label(self, file_path):
        features = []
        labels = []
        descriptions = []
        for line in open(file_path):
            fields = line[:-1].split('\t')
            features.append([float(field.split(':')[1]) for field in fields[3:]])
            labels.append(0 if float(fields[0].split(':')[1]) == 0 else 1)
            descriptions.append(['_'.join(fields[1:3]),])

        return np.asarray(features), labels, descriptions


    def save_res(self, descriptions, predict_res):
        fout = open(self.predict_result_path, 'w')
        for desc, label in zip(descriptions, predict_res):
            desc.append(str(label))
        for desc in sorted(descriptions, key=lambda x:float(x[1]), reverse=True):
            fout.write('\t'.join(desc) + '\n')
        fout.close()

    def train_pedict(self, work_path, raw_feature_path):
        self.set_param(work_path)

        FeatManager().extract(raw_feature_path, self.feature_train, self.feature_predict)
        train_features, train_labels, train_descriptions = self.load_feature_label(self.feature_train)
        gc.collect()
        predict_features, predict_labels, predict_descriptions = self.load_feature_label(self.feature_predict)
        gc.collect()

        dt = DecisionTreeClassifier(criterion='entropy')
        dt.fit(train_features, train_labels)
        gc.collect()

        with open(self.model_path, 'w') as f:
            f = export_graphviz(dt, out_file=f)

        predict_labels = dt.predict(predict_features)
        self.save_res(predict_descriptions, predict_labels)
