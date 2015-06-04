from datetime import datetime
from stockit.model.DT import DT
from stockit.Common import merge_results, exec_cmd
from stockit.model.LR import LR

__author__ = 'wgz'

if __name__ == "__main__":
    liblinear_path = '/Users/wgz/proj/liblinear-1.96/'
    lr_work_path = '/Users/wgz/proj/stock/featProcess/test_LR'
    dt_work_path = '/Users/wgz/proj/stock/featProcess/test_DT'
    raw_feature_path = '/Users/wgz/proj/stock/featProcess/feats'
    merge_result_path = '~/predict_result'
    preview_path = '~/preview'

    today = datetime.today()
    date_str = today.strftime('%Y%m%d')
    merge_result_path += date_str
    preview_path += date_str

    lr = LR('lr', liblinear_path)
    lr.train_and_predict(lr_work_path, raw_feature_path)

    dt = DT()
    dt.train_pedict(dt_work_path, raw_feature_path)

    merge_results([lr_work_path + '/predict_result', dt_work_path + '/predict_result'], merge_result_path)

    cmd = "awk '$2>0.8&&$3!=0{print}' %s | sort -k 2 -n -r | grep -v 'code:3' > %s" % (merge_result_path, preview_path)
    exec_cmd(cmd, 'gen preview')
