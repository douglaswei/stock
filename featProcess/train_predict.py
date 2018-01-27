from datetime import datetime
from stockit.model.DT import DT
from stockit.Common import merge_results, exec_cmd, check_mkdir
from stockit.model.LR import LR
import sys
import os

__author__ = 'wgz'
if __name__ == "__main__":
    liblinear_path = '/Users/wgz/proj/liblinear-1.96/'
    root_path = os.path.dirname(sys.argv[0])

    lr_work_path = root_path + '/data/LR'
    dt_work_path = root_path + '/data/DT'
    raw_feature_path = root_path + '/..//feats'
    merge_result_path = root_path + '/predict_result'
    preview_path = root_path + '~/preview'

    today = datetime.today()
    date_str = today.strftime('%Y%m%d')
    merge_result_path += date_str
    preview_path += date_str

    check_mkdir(lr_work_path)
    check_mkdir(dt_work_path)

    lr = LR('lr', liblinear_path)
    lr.train_and_predict(lr_work_path, raw_feature_path)

    dt = DT()
    dt.train_pedict(dt_work_path, raw_feature_path)

    merge_results([lr_work_path + '/predict_result', dt_work_path + '/predict_result'], merge_result_path)

    cmd = "awk '$2>0.8&&$3!=0{print}' %s | sort -k 2 -n -r | grep -v 'code:3' > %s" % (merge_result_path, preview_path)
    exec_cmd(cmd, 'gen preview')
