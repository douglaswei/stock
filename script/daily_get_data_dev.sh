#! /bin/sh

. script/common.sh

cd crawler

execute /usr/local/bin/scrapy crawl stock_bestgo
execute /usr/local/bin/scrapy crawl stock_ifeng

cd ..

find data/crawl_data -type f | xargs /bin/sed -e 's/,//g' | sort -u > data/raw_records

execute python script/merge_data.py data/raw_records data/records data/catefile

exit

execute python script/gen_category.py data/crawl_data data/category_data
execute sort data/merged_data -o data/merged_data_sort
execute /bin/rm -rf  data/by_code/*

# generate fields data
#   input merged_sorted_data
#   output desired fields for train model

# generate features

cut -f 1 data/train_valid >data/train_valid_col1
cut -f 1 data/test >data/test_col1
cut -f 2 data/train_valid >data/train_valid_col2
cut -f 2 data/test >data/test_col2
cut -f 3- data/train_valid >data/train_valid_feature
cut -f 3- data/test >data/test_feature
execute python script/extract_feature.py data/train_valid_feature data/train_valid_feature_uni data/test_feature data/test_feature_uni
paste -d '\t' data/train_valid_col1 data/train_valid_feature_uni >data/train_valid_final
paste -d '\t' data/test_col1 data/test_feature_uni >data/test_final
execute ~/Downloads/ctr_predict/liblinear-1.95/train -s 0 data/train_valid_final model
execute ~/Downloads/ctr_predict/liblinear-1.95/predict -b 1 data/test_final model test_res 
