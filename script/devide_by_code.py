#! /usr/bin/python

import os
import sys

def devide_by_code(input_filename, output_dir):
    if not os.path.exists(output_dir):
        os.makedirs(output_dir)
    file_in = open(input_filename)
    prev_code = ""
    prev_records = []
    file_out = None
    while True:
        line = file_in.readline()
        if line is None or len(line) < 2:
            break
        fields = line[0:-1].split('\t')
        if len(fields) < 2:
            print line
        stock_code = fields[0]
        stock_date = fields[1]
        records = fields[2:]
        if prev_code != stock_code:
            if file_out is not None:
                file_out.close()
            output_fname = output_dir + os.path.sep + stock_code
            file_out = open(output_fname, 'w')
        else:
            results = [stock_code, stock_date]
            results.extend(records)
            for idx in range(0, len(records)):
                results.append(str(float(records[idx]) - float(prev_records[idx])))
            file_out.write('\t'.join(results) + '\n')
        prev_code = stock_code
        prev_records = records
    if file_out is not None:
        file_out.close()

def devide_by_code_seperate_records(input_filename, output_dir):
    if not os.path.exists(output_dir):
        os.makedirs(output_dir)
    file_in = open(input_filename)
    prev_code = ""
    records_list = []
    while True:
        line = file_in.readline()
        if line is None or len(line) < 2:
            break
        fields = line[0:-1].split('\t')
        if len(fields) < 2:
            print line
        stock_code = fields[0]
        stock_date = fields[1]
        records = fields[2:]
        if prev_code != stock_code and len(records_list) > 0:
            process_records(records_list, output_dir)
            records_list = []
        records_list.append(fields)
        prev_code = stock_code
    if len(records_list) > 0:
        process_records(records_list, output_dir)
        

def gen_gradient_dict(records_list):
    gradient_dict = {}
    for idx in range (1, len(records_list)):
        gradient = []
        stock_date = records_list[idx][1]
        for idg in range (2, len(records_list[idx])):
            gradient.append(str(float(records_list[idx][idg]) - float(records_list[idx - 1][idg])))
        gradient_dict[stock_date] = gradient
    return gradient_dict

def process_records(records_list, output_dir):
    # calculate gradients and clear record list, at last save the results
    gradient_dict = gen_gradient_dict(records_list)
    #gradient_list = ([k,].extend(v) for (k, v) in gradient_dict.items())
    #gradient_list_sort = sorted(gradient_list, key=lambda record:record[0])

    # write file
    stock_name = records_list[0][0]
    out_fname = output_dir + os.path.sep + stock_name
    file_writer = open(out_fname, 'w')
    for idx in range(1, len(records_list)):
        out_records = records_list[idx]
        stock_date = records_list[idx][1]
        gradient = gradient_dict[stock_date]
        out_records.extend(gradient)
        file_writer.write('\t'.join(out_records) + '\n');
    file_writer.close()


if __name__ == "__main__":
    devide_by_code_seperate_records(sys.argv[1], sys.argv[2])
