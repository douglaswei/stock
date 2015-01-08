#! /bin/sh

. script/common.sh

cd crawler

#execute /usr/local/bin/scrapy crawl stock_bestgo

cd ..

find data/crawl_data -type f | xargs /bin/sed -e 's/,//g' | sort -u > data/raw_records

# merge records into pickle file
execute python script/merge_data.py data/raw_records data/records data/catefile
# save records as pickle
execute python script/saveAsPickle.py data/records data/pickle_record_dict

execute python script/gen_train_valid_data.py data/pickle_record_dict data/catefile LrFeatureExtractor 'data/lr'
execute python script/gen_train_valid_data.py data/pickle_record_dict data/catefile KnnFeatureExtractor 'data/knn'
execute python script/gen_train_valid_data.py data/pickle_record_dict data/catefile ExplainableFeatureExtractor 'data/explain'

execute python script/extract_feature.py data/lr_train data/train_feature data/lr_test data/test_feature

execute ~/Downloads/ctr_predict/liblinear-1.95/train -s 0 -c 10 data/train_feature data/model
execute ~/Downloads/ctr_predict/liblinear-1.95/predict -b 1 data/test_feature data/model data/test_res

cut -f 1 data/lr_test  > data/test_col1
sed '1d' data/test_res > data/test_tmp
paste -d '\t' data/test_col1 data/test_tmp | sed 's/ /\t/g' > data/tmp
execute python script/sortRes.py 2 data/tmp data/stock_res_$DATE

sed 's/\t\w*:/\t/g' data/knn_train > data/knn_train_feature

sed 's/\t\w*:/\t/g' data/knn_test > data/knn_test_feature

execute ./script/knn.py data/knn_train_feature data/knn_test_feature data/knn_out_$DATE knn/pickle_record_dict 3 "5,10,20,30,50"

cat  data/knn_out_$DATE  | grep 'cluster' | sort -k 4 -n -r > data/knn_predict_$DATE

exit


# generate fields data
#   input merged_sorted_data
#   output desired fields for train model

# generate features

