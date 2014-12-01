#! /usr/bin/python

import sys

def uniform(in_fname, out_fname):
    min_list = []
    max_list = []
    for line in open(in_fname):
        if len(line) < 4:
            break;
        fields = line[:-1].split('\t')
        if len(min_list) == 0:
            for field in fields:
                min_list.append(float(field))
                max_list.append(float(field))
        for idx in range(0, len(fields)):
            field = float(fields[idx])
            if min_list[idx] > field:
                min_list[idx] = field
            if max_list[idx] < field:
                max_list[idx] = field

    fout = open(out_fname, 'w')
    for line in open(in_fname):
        if len(line) < 4:
            break;
        records = []
        fields = line[:-1].split('\t')
        for idx in range(0, len(fields)):
            data = float(fields[idx])
            result = (data - min_list[idx]) / (max_list[idx] - min_list[idx] + 0.1)
            records.append("%f" % (result))
        fout.write('\t'.join(records) + '\n')
    fout.close()


if __name__ == "__main__":
    uniform(sys.argv[1], sys.argv[2])
