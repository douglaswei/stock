__author__ = 'wgz'

import numpy as np
import sklearn as sk
from sklearn.cluster import KMeans


class Knn:
    def __init__(self, n_clusters, train_data, predict_data, out_prefix):
        self.n_clusters = n_clusters
        self.train_data = train_data
        self.predict_data = predict_data
        self.out_prefix = out_prefix
        pass

    def execute(self):
        for n_cluster in self.n_clusters:
            model = self.train(self.train_data, n_cluster)
            train_cluster_res, train_dis_res = self.predict(model, self.train_data)
            predict_cluster_res, predict_dis_res = self.predict(model, self.predict_data)

        self.get_statistic_info(None, None)
        pass

    def train(self, features, n_cluster):
        model = KMeans(init='k-means++', n_clusters=n_cluster, n_init=10)
        model.fit(features)
        return model

    def predict(self, model, features):
        cluster_res = model.predict(features)
        distances = model.transform(features)
        cluster_idx_array = [
                [idx for idx in range(len(cluster_res)) if cluster_res[idx] == cluster]
                for cluster in set(cluster_res)]
        cluster_avgDist_array = [
                np.mean(np.asarray([distances[idx][cluster] for idx in range(len(cluster_res)) if cluster_res[idx] == cluster]))
                for cluster in set(cluster_res)]
        return cluster_idx_array, cluster_avgDist_array


    def get_statistic_info(self, cluster_res, distances):
        pass

    def gen_result(self):
        pass
