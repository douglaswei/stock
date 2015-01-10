#! /usr/bin/python

sz_code = "sz399001"
sh_code = "sh000001"

class config():
    raw_records_file = 'test_raw_records'
    records_file = 'test_records'
    category_file = '../data/category'
    feat_window = 250
    label_window = 10
    upper_threohold = 0.4
    lower_thredhold = -0.1
    sample_file_in = 'test_train'
    sample_file_out = 'test_train_sample'
    sample_postive_only = False
    sample_pn_ratio = 0.3

    field_in_need = [
        'fund', 'hd'
    ]

    feat_begin_idx = 3

    knn_clusters = [5, 10, 20, 30, 50, 80, 120]
    knn_dir = './'
    knn_train_filename = 'knn_train'
    knn_test_filename = 'knn_test'
    knn_output_filename = 'knn_output'
    knn_info_filename = 'knn_info'
    knn_threshold_num = 15
    knn_threshold_percent = 0.75



recordsFiledMap = {
    'ma' : 0,
    'ma_gradient' : 1,
    'exchange_rate' : 2,
    'ltsz' : 3,
    'zjlr' : 4,
    'ydjl' : 5,
}
