# encoding=utf-8
import gc

from stockit.Common import exec_cmd


__author__ = 'wgz'

import commands
from random import Random
from ..FeatManager import FeatManager


class LR():
    def __init__(self, name, bin_path):
        self.name = name

        if bin_path[-1] != '/':
            bin_path += '/'
        self.bin_path = bin_path

        self.train_bin = bin_path + 'train'
        self.predict_bin = bin_path + 'predict'

    def set_params(self, style, cost, work_path):
        self.style = style
        self.cost = cost

        if work_path[-1] != '/':
            work_path += '/'
        self.work_path = work_path

        self.feature_raw_train_path = self.work_path + 'raw_train_feature'
        self.feature_raw_predict_path = self.work_path + 'raw_predict_feature'

        self.feature_train_path = self.work_path + 'train_feature'
        self.feature_predict_path = self.work_path + 'predict_feature'
        self.model_path = self.work_path + 'model'

        self.validate_mid_path = self.work_path + 'validate_mid'
        self.predict_mid_path = self.work_path + 'predict_mid'

        self.validate_result_path = self.work_path + 'validate_result'
        self.predict_result_path = self.work_path + 'predict_result'


    def sample(self, in_path, out_path, postive_sample, pos_count, neg_count):
        (count_need, count_total) = (pos_count, neg_count) if pos_count < neg_count else (neg_count, pos_count)
        random = Random()
        fout = open(out_path, 'w')
        for line in open(in_path):
            fields = line[:-1].split('\t')
            label = float(fields[0].split(':')[1])
            is_postive = label > 0

            # if pos and sample_postive or neg and sample_neg
            if not (is_postive ^ postive_sample):
                count_total -= 1
                r = random.random()
                if r * (count_total + 1) > count_need:
                    continue
                count_need -= 1
            fields = line[:-1].split('\t')
            fout.write(fields[0].split(':')[1] + '\t' + '\t'.join(fields[3:]) + '\n')


    def adjust_feats(self):
        """
           整理feature,
           1. 只保留label和feature，shell+cut+awk
           2. 采样,保证正例和负例比例
        :return:
        """
        pos_count = 0
        neg_count = 0
        for line in open(self.feature_raw_train_path):
            label = line[:-1].split('\t')[0].split(':')[1]
            is_postive = float(label) > 0
            if is_postive:
                pos_count += 1
            else:
                neg_count += 1

        is_postive_sample = True if pos_count > neg_count else False

        self.sample(self.feature_raw_train_path, self.feature_train_path, is_postive_sample, pos_count, neg_count)

        cmd = 'cut -f 1,4- %s | cut -d ":" -f 2- > %s' % (self.feature_raw_predict_path, self.feature_predict_path)
        (status, output) = commands.getstatusoutput(cmd)
        return

    def train_and_predict(self, work_path, raw_feature_path):
        self.set_params(11, 20, work_path)

        # feature 离散化处理
        FeatManager().extract_discrete_feat(raw_feature_path, self.feature_raw_train_path,
                                            self.feature_raw_predict_path, 3, 500)
        gc.collect()
        print('finish extract feats')

        self.adjust_feats()
        gc.collect()
        print('finish adjust feats')

        self.train()
        gc.collect()
        print('finish train')

        # self.predict(self.feature_train_path, self.validate_mid_path)
        self.predict(self.feature_predict_path, self.predict_mid_path)
        gc.collect()
        print('finish predict')

        # self.save_result(self.feature_raw_train_path, self.validate_mid_path, self.validate_result_path)
        self.save_result(self.feature_raw_predict_path, self.predict_mid_path, self.predict_result_path)
        gc.collect()
        print('finish saving')

    def train(self):
        """
        模型训练，模型输出到文件
        :return:
        """
        cmd = '%s -s %d -c %f %s %s' % (self.train_bin, self.style, self.cost, self.feature_train_path, self.model_path)
        exec_cmd(cmd, 'train model')

    def predict(self, feat_path, result_path):
        """
        使用模型文件进行 validate / predict
        :param feat_path:
        :param result_path:
        :return:
        """
        cmd = '%s -b 0 %s %s %s' % (self.predict_bin, feat_path, self.model_path, result_path)
        exec_cmd(cmd, 'predict')

    def save_result(self, raw_feat_file, res_file_path, output_path):
        fout = open(output_path, 'w')
        f_raw_feat = open(raw_feat_file)
        f_predict_res = open(res_file_path)
        res = []

        while True:
            line = f_raw_feat.readline()
            if line == None or len(line) == 0:
                break
            fields = ['_'.join(line[:-1].split('\t')[1:3]), ]

            line = f_predict_res.readline()
            predict_label = line[:-1]
            fields.append(predict_label)
            res.append(fields)

        for fields in sorted(res, key=lambda x: float(x[1]), reverse=True):
            fout.write('\t'.join(fields) + '\n')

        fout.close()

