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

    field_in_need = [
        'fund', 'hd'
    ]


recordsFiledMap = {
    'ma' : 0,
    'ma_gradient' : 1,
    'exchange_rate' : 2,
    'ltsz' : 3,
    'zjlr' : 4,
    'ydjl' : 5,
}
