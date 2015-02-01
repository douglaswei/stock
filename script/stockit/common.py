#! /usr/bin/python
# coding:utf-8

sz_code = "sz399001"
sh_code = "sh000001"

class config():
    raw_records_file = '../data/raw_records'
    records_file = './knn/test_records'
    pickle_records_file = 'pickle_records'
    feat_window = 100
    label_window = 5
    upper_threohold = 0.4
    lower_thredhold = -0.1
    sample_file_in = './knn/test_train'
    sample_file_out = './knn/test_train_sample'
    sample_postive_only = False
    sample_pn_ratio = 0.3

    field_in_need = [
        'fund', 'hd'
    ]

    feat_begin_idx = 3

    knn_clusters = [5, 10, 20, 30, 50, 80, 120]
    knn_dir = 'knn/'
    knn_train_filename = 'knn_train'
    knn_test_filename = 'knn_test'
    knn_output_filename = 'knn_output'
    knn_info_filename = 'knn_info'
    knn_threshold_num = 15
    knn_threshold_percent = 0.7

    lr_dir = './'

    lr_model_filename = 'model'

    lr_train_bin = '~/proj/libsvm-3.20/svm-train'
    lr_predict_bin = '~/proj/libsvm-3.20/svm-predict'
    lr_train_option = '-s 3 -t 2'
    lr_predict_option = ''

    lr_train_filename = 'lr_train'
    lr_train_feature_filename = 'train_feature'
    lr_train_res_filename = 'train_res'

    lr_validate_filename = 'lr_train'#'validate'
    lr_validate_feature_filename = 'validate_feature'
    lr_validate_res_filename = 'validate_res'

    lr_test_filename = 'lr_test'
    lr_test_feature_filename = 'test_feature'
    lr_test_res_filename = 'test_res'

    lr_res_filename = 'lr_res'

    db_string = 'sqlite:///./sqlalchemy.db'



recordsFiledMap = {
    'ma' : 0,
    'ma_gradient' : 1,
    'exchange_rate' : 2,
    'ltsz' : 3,
    'zjlr' : 4,
    'ydjl' : 5,
}


'''
shdjtRecordMap = {
    'ma': #价格
    'ma_grad', #涨幅
    'ddx', #
    'ddy', #
    'ddz', #
    'jingE', #净额
    'teDaChaLiang', #特大差量
    'daDanChaLiang', #大单差量
    'zhongDanChaLiang', #中单差量
    'xiaoDanChaLiang', #小单差量
    'qiangDu', #强度
    'zhuDongLv', #主动率
    'tongChiLv', #通吃率
    'teDaCha', #特大差
    'daDanCha', #大单差
    'zhongDanCha', #中单差
    'xiaoDanCha', #小单差
    'huoYueDu', #活跃度
    'danShuBi', #单数笔
    'ddx5' : 0,
    'ddy5' : 0,
    'ddx60' : 0,
    'ddy60' : 0,
    'ddx_red', #ddx翻红天数
    'ddx_continue', #ddx连续翻红天数
    'xiaoDanChaShou', #小单差手
    'ziJinQiangDu', #资金强度
    'maiRuDanShu', #买入单数
    'maiChuDanShu', #卖出单数
    'maiDanJunShou', #买单均手
    'maiDanJunShou', #卖单均手
    'xiaoDanLeiJi', #小单累计
    'jingELeiJi', #净额累计
    'teDaMaiRu', #特大买入
    'teDaMaiChu', #特大卖出
    'daDanMaiRu', #大单买入
    'daDanMaiChu', #大单卖出
    'zhongDanMaiRu', #中单买入
    'zhongDanMaiChu', #中单卖出
    'xiaoDanMaiRu', #小单买入
    'xiaoDanMaiChu', #小单卖出
    'huanShouLv', #换手率
    'shiYingLv', #市盈率
    'meiGuShouYi', #每股收益
    'teDaMaiRu', #特大买入
    'teDaMaiChu', #特大卖出
    'daDanMaiRu', #大单买入
    'daDanMaiChu', #大单卖出
    'zhongDanMaiRu', #中单买入
    'zhangDanMaiChu', #中单卖出
    'xiaoDanMaiRu', #小单买入
    'xiaoDanMaiChu', #小单卖出
    'liangBi', #量比
}
'''
