import gc

__author__ = 'wgz'

import sys

from FeatTranslator import FeatTranslator


labelName = "label"
codeName = "code"
dateName = "date"


class FeatManager:
    def set_train_predict_path(self, feat_train_path, feat_predict_path):
        self.trainFile = open(feat_train_path, 'w')
        self.predictFile = open(feat_predict_path, 'w')

    def extract(self, raw_feat_path, feat_train_path, feat_predict_path):
        self.set_train_predict_path(feat_train_path, feat_predict_path)
        for line in open(raw_feat_path):
            line = line[:-1]
            fields = [item.split(":") for item in line.split("\t")]
            field_map = dict(fields)

            label, code, date = field_map.get(labelName), field_map.get(codeName), field_map.get(dateName)

            out_file = self.predictFile if len(label) == 0 else self.trainFile
            label_res = label < 0 and 0 or 1

            out_str = "%s:%f\t%s:%s\t%s:%s" % (labelName, label_res, codeName, code, dateName, date)

            translator = FeatTranslator()
            feature_map = translator.extract(field_map, False)
            sorted_featids = sorted(feature_map.keys())
            for featId in sorted_featids:
                out_str += "\t%d:%s" % (featId, feature_map[featId])

            out_file.write(out_str + '\n')

    def extract_maxs_mins(self, raw_feat_path, feat_beg_idx):
        feature_max_values = []
        feature_min_values = []
        for line in open(raw_feat_path):
            fields = [float(item.split(':')[1]) for item in line[:-1].split('\t')[feat_beg_idx:]]
            if len(feature_max_values) == 0:
                feature_max_values = fields[:]
            if len(feature_min_values) == 0:
                feature_min_values = fields[:]
            feature_max_values = map(max, zip(feature_max_values, fields))
            feature_min_values = map(min, zip(feature_min_values, fields))
        return feature_max_values, feature_min_values

    def extract_discrete_feat(self, raw_feat_path, feat_train_path, feat_predict_path, feat_beg_idx, span_num):
        self.set_train_predict_path(feat_train_path, feat_predict_path)
        feature_max_values, feature_min_values = self.extract_maxs_mins(raw_feat_path, feat_beg_idx)
        feature_diffs = map(lambda x: x[0] - x[1], zip(feature_max_values, feature_min_values))
        feature_spans = map(lambda x: x/span_num or 0.1, feature_diffs)
        translator = FeatTranslator()

        for line in open(raw_feat_path):
            kvs = [item.split(':') for item in line[:-1].split('\t')]
            raw_feature_map = dict(kvs)
            label, code, date = raw_feature_map.get(labelName), raw_feature_map.get(codeName), raw_feature_map.get(dateName)
            label_res = 0 if (len(label) == 0 or float(label) <= 0) else float(float(label)/30)

            feature_map = dict(map(lambda (v, s, m): [v[0], (float(v[1])-m)/s], zip(kvs[feat_beg_idx:], feature_spans, feature_min_values)))
            feature_res_map = translator.extract(feature_map, True)
            out_str = "%s:%f\t%s:%s\t%s:%s" % (labelName, label_res, codeName, code, dateName, date)

            for featId in sorted(feature_res_map.keys()):
                out_str += "\t%d:%s" % (featId, feature_res_map[featId])

            fout = self.predictFile if len(label) == 0 else self.trainFile
            fout.write(out_str + '\n')


if __name__ == "__main__":
    featManager = FeatManager("test")
    featManager.extract("../feats")
    sys.exit(0)
