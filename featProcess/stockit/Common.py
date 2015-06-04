import commands
import json
from urllib2 import urlopen

import numpy as np


__author__ = 'wgz'


def load_data(fpath, feat_beg_idx):
    raw_records = []
    records = []
    for line in open(fpath):
        line = line[:-1]
        fields = line.split("\t")
        raw_records.append(fields)
        records.append([float(field.split(":")[1]) for field in fields[feat_beg_idx:]])
    return raw_records, np.asarray(records)


def load_data_as_list(fpath):
    records = []
    for line in open(fpath):
        fields = line[:-1].split("\t")
        records.append(fields)
    return records


def exec_cmd(cmd, task_name):
    print '--- [%s] begin ---' % task_name
    print '--- [%s] cmd: ---\n' % task_name + cmd
    (status, output) = commands.getstatusoutput(cmd)
    print '--- [%s] finish ---' % task_name
    print '--- [%s]result: %d ---' % (task_name, status)
    print '--- [%s] output: ---\n' % task_name + output


def add_result_to_map(result_path, result_map):
    for line in open(result_path):
        k, v = line[:-1].split('\t')
        v_list = result_map.get(k, [])
        v_list.append(v)
        result_map[k] = v_list


def merge_results(result_paths, outout_path):
    result_map = {}
    for result_path in result_paths:
        add_result_to_map(result_path, result_map)

    fout = open(outout_path, 'w')
    for k, v_list in result_map.items():
        fout.write(k + '\t' + '\t'.join(v_list) + '\n')


def get_current_info(stock_code):
    url = 'http://ddx.gubit.cn/ddelist.php?code=%s' % stock_code
    response = urlopen(url, timeout=10).read()
    data = json.loads(response)['data']
    if len(data) == 0:
        return []
    return [data[0]['spj'], data[0]['zf'], ]