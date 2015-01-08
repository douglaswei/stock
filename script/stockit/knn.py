#! /usr/bin/python
# coding:utf-8

import sys
import os
import gc
import pickle
import numpy as nu
import sklearn as sk
from sklearn.cluster import KMeans
from draw import drawLines

dict_postive_percent = {}
dict_predict_cluster = {}

# return nu.ndarray
def loadData(fileName, begin_field):
    raw_records = []
    records = []
    for line in open(fileName):
        fields = line[:-1].split('\t')
        raw_records.append(fields)
        records.append( [float(field) for field in fields[begin_field:]] )
    return raw_records, nu.asarray(records)


# return KMeans
def trainModel(data, n_clusters):
    model = KMeans(init='k-means++', n_clusters = n_clusters, n_init = 10)
    model.fit(data)
    return model


def getPredictResults(model, nu_train_data, raw_data):
    clusters = model.predict(nu_train_data)
    distances = model.transform(nu_train_data)
    result = {}
    for i_cluster in range(distances.shape[1]):
        cluster_code_date_label_dis =[raw_data[idx][:3] + [str(distances[idx][i_cluster]),] \
                for idx in range(len(clusters))  if clusters[idx] == i_cluster]
        result[i_cluster] = sorted(cluster_code_date_label_dis, key=lambda item:item[3])
    return result

def saveTrainData(fout, cluster_info):
    prefix = 'train'
    n_clusters = len(cluster_info.keys())
    for i_cluster in cluster_info.keys():
        cluster_info_i = cluster_info[i_cluster]
        pos_num = sum([int(float(item[2])>0) for item in cluster_info_i])
        total_num = len(cluster_info[i_cluster])
        for [code, date, label, dis] in cluster_info[i_cluster]:
            fout.write('%s_%d_%d\t%s\t%s\t%s\t%s\n' % \
                    (prefix, n_clusters, i_cluster, dis, label, code, date))

        fout.write('%s_%d_%d:postive percent:%.2f%%, total_num:%d\n' % \
                (prefix, n_clusters, i_cluster, pos_num * 100.0 / total_num, total_num))
        key = '%d_%d' % (n_clusters, i_cluster)
        dict_postive_percent[key] = [pos_num * 100.0 / total_num , total_num]


def saveTestData(fout, cluster_info):
    prefix = 'test'
    n_clusters = len(cluster_info.keys())
    for i_cluster in cluster_info.keys():
        cluster_info_i = cluster_info[i_cluster]
        cluster_value = '%d_%d' % (n_clusters, i_cluster)
        for [code, date, label, dis] in cluster_info[i_cluster]:
            key = code + '\t' + date
            value = dict_predict_cluster.get(key, [])
            value.append(cluster_value)
            dict_predict_cluster[key] = value
            fout.write('%s_%d_%d\t%s\t%s\t%s\t%s\n' % \
                    (prefix, n_clusters, i_cluster, dis, label, code, date))


def writeTestData(fout):
    for k,v in dict_predict_cluster.items():
        value = []
        for cluster in v:
            pos_percent, total_num = dict_postive_percent[cluster]
            if (pos_percent > 30) and (total_num > 1):
                value.append('%s-%f-%d' % (cluster, pos_percent, total_num))
        if len(value) > 0:
            fout.write(k + '\t' + "clusters\t" + str(len(value)) + '\t' + '\t'.join(value) + '\n')


def uniform_with_max_min(data, max_data, min_data):
    for record in data:
        for idx in range(record.shape[0]):
            record[idx] = (float(record[idx]) - min_data[idx]) / (max_data[idx] - min_data[idx])


def uniform_data(train_data, test_data):
    max_data = nu.asarray([
            nu.max(train_data, axis=0),
            nu.max(test_data, axis=0),
    ])
    min_data = nu.asarray(
            [nu.min(train_data, axis=0),
            nu.min(test_data, axis=0)
    ])
    max_thrd = nu.max(max_data, axis=0)
    min_thrd = nu.min(min_data, axis=0)
    uniform_with_max_min(train_data, max_thrd, min_thrd)
    uniform_with_max_min(test_data, max_thrd, min_thrd)


def main(train_filename,
        test_filename,
        out_filename,
        pickle_filename,
        label_field,
        cluster_list):
    fout = open(out_filename, 'w')
    # 1. load data set
    raw_train_data, nu_train_data = loadData(train_filename, label_field)
    raw_test_data, nu_test_data = loadData(test_filename, label_field)
    # uniform data
    #uniform_data(nu_train_data, nu_test_data)
    for n_cluster in (int(item) for item in cluster_list.split(',')):
        # 2. train model
        model = trainModel(nu_train_data, n_cluster)
        # 3. predict train_data
        # return dict {cluster: [] code, date, label, dis}
        cluster_info_train = getPredictResults(model, nu_train_data, raw_train_data)
        # 4. predict test_data
        cluster_info_test = getPredictResults(model, nu_test_data, raw_test_data)
        # 5. save res
        saveTrainData(fout, cluster_info_train)
        saveTestData(fout, cluster_info_test)
        del model
        gc.collect()
    writeTestData(fout)
    fout.close()
    return


if __name__ == "__main__":
    main(sys.argv[1],
            sys.argv[2],
            sys.argv[3],
            sys.argv[4],
            int(sys.argv[5]),
            sys.argv[6],
    )
