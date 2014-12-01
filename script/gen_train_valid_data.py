#! /usr/bin/python

import sys
import os

def gen_data(input_dir, fout_train, fout_test, feature_window, value_window, step):
    # read data from file
    # gen data by window size
    os.path.walk(input_dir, process_files, (fout_train, fout_test, feature_window, value_window, step))


def process_file(filename, fout_train, fout_test, feature_window, value_window, step):
    fin = open(filename, 'r')
    records = []
    for line in  fin.readlines():
        if len(line) < 2:
            continue
        records.append(line[:-1].split('\t'))
    fin.close()
    total_window = feature_window + value_window
    for beg in range(0, len(records) - total_window, step):
        label = 0
        for idx in range(0, value_window):
            label += float(records[beg + feature_window + idx][3])
        features = [str(label), records[beg][0],]
        for idx in range(0, feature_window):
            features.extend(records[beg + idx][2:])
        fout_train.write('\t'.join(features) + '\n')

    features = ["0", records[0][0],]
    for idx in range(len(records) - feature_window, len(records)):
        if idx < 0:
            break
        features.extend(records[idx][2:])
    fout_test.write('\t'.join(features) + '\n')


def process_files(args, dirname, names):
    [fout_train, fout_test, feature_window, value_window, step] = args
    for filepath in names:
        filename = os.path.join(dirname, filepath)
        if not os.path.isfile(filename):
            continue
        process_file(filename, fout_train, fout_test, feature_window, value_window, step)


def main():
    if len(sys.argv) < 7:
        return
    input_dir = sys.argv[1]
    fout_train = open(sys.argv[2], 'w')
    fout_test = open(sys.argv[3], 'w')
    feature_window = int(sys.argv[4])
    value_window = int(sys.argv[5])
    step = int(sys.argv[6])
    gen_data(input_dir, fout_train, fout_test, feature_window, value_window, step)
    fout_train.close()
    fout_test.close()


if __name__ == '__main__':
    main()
