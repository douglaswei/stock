#! /bin/bash

python script/gen_train_valid_data.py data/pickle_record_dict data/catefile data/train data/test data/raw_train data/raw_test

awk '{str=$1;for(idx=2;idx<=NF;++idx){len=split($idx,items,":");str=str"\t"items[len]} print str}' data/raw_train > data/knn_train

awk '{str=$1;for(idx=2;idx<=NF;++idx){len=split($idx,items,":");str=str"\t"items[len]} print str}' data/raw_test> data/knn_test

./script/knn_new.py data/knn_train data/knn_test data/knn_out knn/pickle_record_dict 3 "5,10,20,30"

