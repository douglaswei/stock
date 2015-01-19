#! /usr/bin/python
# coding:utf-8

import sys
import os
import gc
import pickle
import logging
import commands
import numpy as np

import sklearn as sk
from sklearn.cluster import KMeans

import common


######################################################

class BaseLr(object):
    def __init__(self, config = common.config()):
        self.config = config


    def cutData(self, input_file, output_file, beg_field):
        fout = open(output_file, 'w')
        for line in open(input_file):
            items = line[:-1].split('\t')[beg_field:]
            fout.write('\t'.join(items) + '\n')
        fout.close()


    def prepareData(self):
        train_filename = self.config.lr_dir + self.config.lr_train_filename
        train_feature_filename = self.config.lr_dir + self.config.lr_train_feature_filename
        validate_filename = self.config.lr_dir + self.config.lr_validate_filename
        validate_feature_filename = self.config.lr_dir + self.config.lr_validate_feature_filename
        test_filename = self.config.lr_dir + self.config.lr_test_filename
        test_feature_filename = self.config.lr_dir + self.config.lr_test_feature_filename

        self.cutData(train_filename, train_feature_filename, self.config.feat_begin_idx - 1)
        self.cutData(validate_filename, validate_feature_filename, self.config.feat_begin_idx - 1)
        self.cutData(test_filename, test_feature_filename, self.config.feat_begin_idx - 1)


    def run(self):
        train_feature_filename = self.config.lr_dir + self.config.lr_train_feature_filename
        train_res_filename = self.config.lr_dir + self.config.lr_train_res_filename
        validate_feature_filename = self.config.lr_dir + self.config.lr_validate_feature_filename
        validate_res_filename = self.config.lr_dir + self.config.lr_validate_res_filename
        test_feature_filename = self.config.lr_dir + self.config.lr_test_feature_filename
        test_res_filename = self.config.lr_dir + self.config.lr_test_res_filename
        model_filename = self.config.lr_dir + self.config.lr_model_filename

        # 1. train model
        self.train(train_feature_filename, model_filename)
        # 2. validate model on train file
        self.validate(train_feature_filename, train_res_filename)
        # 3. validate model on validate file
        self.validate(validate_feature_filename, validate_res_filename)
        # 4. validate model on test file
        self.validate(test_feature_filename, test_res_filename)
        # 5. collect information
        self.genReport(train_res_filename, validate_res_filename, test_res_filename)


    def train(self, train_featrure_filename, model_filename):
        logging.info('train_file[%s], model_file[%s]' % (train_featrure_filename, model_filename))
        train_cmd = '%s %s %s %s' % (\
                self.config.lr_train_bin,\
                self.config.lr_train_option,\
                train_featrure_filename,\
                model_filename)
        status, output = commands.getstatusoutput(train_cmd)
        logging.info(output)
        if status != 0:
            sys.exit(-1)


    def validate(self, model_filename, feature_filename, output_filename):
        logging.info('validataion, model:[%s], input[%s], output[%s]' % \
                (model_filename, feature_filename, output))
        predict_cmd = '%s %s %s %s' % (\
                self.config.lr_predict_bin,\
                self.cofnig.lr_predict_option,\
                feature_filename,\
                model_filename,\
                output_filename)
        status, output = commands.getstatusoutput(predict_cmd)
        logging(output)
        if status != 0:
            sys.exit(-1)


    def genReport(self, train_res_filename, validate_res_filename, test_res_filename):
        pass

