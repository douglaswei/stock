import commands

__author__ = 'wgz'

import numpy as np

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

def discreate_feats(fpaths, feat_beg_idx, span_num, sufix):
    records = []
    for fpath in fpaths:
        records.extend(load_data_as_list(fpath))

    np_records = np.asarray([[float(item.split(':')[1]) for item in record[feat_beg_idx:]] for record in records])
    maxs = np_records.max(0)
    mins = np_records.min(0)
    spans = [float(maxs[idx] - mins[idx]) / span_num for idx in range(maxs.shape[0])]

    for fpath in fpaths:
        fout = open(fpath + sufix, 'w')
        for line in open(fpath):
            fields = line[:-1].split('\t')
            feats = fields[feat_beg_idx:]
            label = [float(fields[0].split(':')[1])]
            out_feats = [int((feats[idx] - mins[idx]) / spans[idx]) if spans[idx] == 0 else 0 for idx in range(len(feats))]

    return np_records

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
