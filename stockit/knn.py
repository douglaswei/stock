#! /usr/bin/python
# coding:utf-8

import sys
import os
import gc
import pickle
import numpy as np
import sklearn as sk
from sklearn.cluster import KMeans
import common


######################################################

class KnnClassifer(object):
    def __init__(self, config = common.config()):
        self.config = config
        self.train_lable = None
        self.train_data = None
        self.test_label = None
        self.test_data = None
        self.model = None
        self.cluster_info_dict = {}
        self.predict_result_dict = {}

    def __del__(self):
        pass

    def knn(self):
        out_filename = self.config.knn_dir + self.config.knn_output_filename
        train_filename = self.config.knn_dir + self.config.knn_train_filename
        test_filename = self.config.knn_dir + self.config.knn_test_filename
        feat_begin_idx = self.config.feat_begin_idx
        fout = open(out_filename, 'w')

        for i_cluster in self.config.knn_clusters:
            self.train_predict(i_cluster,
                    train_filename,
                    test_filename,
                    feat_begin_idx,
                    fout)
    
    def train_predict(self, n_clusters, train_filename, test_filename, feat_begin_idx, fout):
        self.n_clusters = n_clusters
        self.feat_begin_idx = feat_begin_idx
        
        self.train_lable, self.train_data = self.__loadData(train_filename)
        self.test_label, self.test_data = self.__loadData(test_filename)

        model = self.__trainModel(self.train_data, n_clusters)
        train_cluster, train_distance = self.__predict(model, self.train_data)
        test_cluster, test_distance = self.__predict(model, self.train_data)

        self.__collectClusterInfo(train_cluster, self.train_lable, fout)
        self.__collectPredictRes(self.train_lable, train_cluster, train_distance, fout, True)
        self.__collectPredictRes(self.test_label, test_cluster, test_distance, fout, False)


    def __loadData(self, filename):
        label = []
        data = []
        for line in open(filename):
            items = line[:-1].split('\t')
            label.append(items[:self.feat_begin_idx])
            data.append([float(ele.split(':')[1]) for ele in items[self.feat_begin_idx:]])
        return np.asarray(label), np.asarray(data)


    def __trainModel(self, train_data, n_clusters):
        if self.model is not None:
            del self.model
            gc.collect()
        self.model = KMeans(init='k-means++', n_clusters = n_clusters, n_init = 10)
        self.model.fit(train_data)
        return self.model


    def __predict(self, model, data):
        cluster_res = model.predict(data)
        distances = model.transform(data)
        return cluster_res, distances

    
    def __collectClusterInfo(self, cluster_res, labels, fout):
        for cluster_idx in range(self.n_clusters):
            cluster_record_idxs = filter(lambda x: cluster_res[x] == cluster_idx,
                    range(cluster_res.shape[0]))
            record_num = len(cluster_record_idxs)

            postive_record_idxs = filter(lambda x: float(labels[x][2])>0, cluster_record_idxs)
            postive_num = len(postive_record_idxs)
            k = self.__getClusterDescription(self.n_clusters, cluster_idx)
            v_d = self.cluster_info_dict.get(k, {})
            v_d['n'] = record_num
            v_d['np'] = postive_num
            v_d['p'] = float(postive_num) / record_num
            self.cluster_info_dict[k] = v_d
            fout.write('%s\t%d:%d:%f\n' % (k, v_d['n'], v_d['np'], v_d['p']))


    def __collectPredictRes(self, labels, cluster_res, distances, fout, is_train=False):
        for i_cluster, i_label in zip(range(len(cluster_res)), labels):
            cluster_desc = self.__getClusterDescription(self.n_clusters, cluster_res[i_cluster])
            prefix = 'train:'
            if not is_train:
                prefix = 'test:'
            label_desc = prefix + ':'.join(i_label)
            v_d = self.cluster_info_dict[cluster_desc]
            #if v_d['n'] > self.config.knn_threshold_num \
            #        and v_d['p'] > self.config.knn_threshold_percent:
            fout.write('%s\t%s:%d:%d:%f\n' % (label_desc, cluster_desc, v_d['n'], v_d['np'], v_d['p']))


    def __getClusterDescription(self, n_clusters, i_cluster):
        return 'cluster_' + str(n_clusters) + '_' + str(i_cluster)


def collectInfo(in_filename,
        out_filename,
        threshold_num = common.config.knn_threshold_num,
        threshold_per = common.config.knn_threshold_percent):
    code_clusters_dict = {}
    for line in open(in_filename):
        if 'train' in line or 'test' in line:
            items = line[:-1].split('\t')
            k, v = items
            n, p = v.split(':')[1:4:2]
            if float(n) < threshold_num or float(p) < threshold_per:
                continue
            clusters = code_clusters_dict.get(k, [])
            clusters.append(v)
            code_clusters_dict[k] = clusters
    
    res_list = []
    for k, clusters in code_clusters_dict.items():
        res = [k]
        n = 0
        pn = 0
        for cluster in clusters:
            l_n, l_pn = cluster.split(':')[1:3]
            n += float(l_n)
            pn += float(l_pn)
        res.append('%f:%f' % (n, pn/n))
        for cluster in clusters:
            res.append('\t' + cluster)
        res_list.append(res)

    fout = open(out_filename, 'w')
    for res in sorted(res_list, key=lambda x: [len(x), x[0]], reverse = True):
        fout.write('\t'.join(res) + '\n')



def v_main():
    knn = KnnClassifer(common.config())
    knn.knn()


if __name__ == "__main__":
    v_main()

