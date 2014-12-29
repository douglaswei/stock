#! /usr/bin/ptyhon

import sys

field = int(sys.argv[1])
inFilename = sys.argv[2]
outFilename = sys.argv[3]

records = [line[:-1].split('\t') for line in open(inFilename)]

fout = open(outFilename, 'w')
for item in sorted(records, key=lambda record:float(record[field]), reverse=True):
    fout.write('\t'.join(item) + '\n')

fout.close()
