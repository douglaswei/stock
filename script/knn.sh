#! /bin/bash

. script/common.sh

WORK_DIR=$DATA_DIR"/knn"
OUT_FILE=$WORK_DIR"/feature"
TRAIN_FILE=$OUT_FILE"_train"
TEST_FILE=$OUT_FILE"_test"
TRAIN_FEATURE=$TRAIN_FILE"_feat"
TRAIN_FEATURE_SAMPLE=$TRAIN_FEATURE"_sample"
TRAIN_FEATURE_POS=$TRAIN_FEATURE"_pos"
TEST_FEATURE=$TEST_FILE"_feat"
KNN_OUT=$WORK_DIR"/out_"$DATE
KNN_PREDICT=$WORK_DIR"/predict_"$DATE
LABLE_FIELD=3

echo $WORK_DIR
echo $OUT_FILE
echo $TRAIN_FILE
echo $TEST_FILE
echo $TRAIN_FEATURE
echo $TEST_FEATURE
echo $KNN_OUT
echo $KNN_PREDICT

execute python script/gen_train_valid_data.py data/pickle_record_dict data/catefile KnnFeatureExtractor $OUT_FILE

sed 's/\t\w*:/\t/g' $TRAIN_FILE > $TRAIN_FEATURE

sed 's/\t\w*:/\t/g' $TEST_FILE > $TEST_FEATURE

awk '{if($3>0)print}' $TRAIN_FEATURE > $TRAIN_FEATURE_POS

execute ./script/knn.py $TRAIN_FEATURE $TEST_FEATURE $KNN_OUT knn/pickle_record_dict $LABLE_FIELD "5,10,20,30,50"

execute ./script/knn.py $TRAIN_FEATURE_POS $TEST_FEATURE $KNN_OUT"_pos" knn/pickle_record_dict $LABLE_FIELD "5,10,20,30,50"

cat $KNN_OUT  | grep 'cluster' | sort -k 4 -n -r > $KNN_PREDICT
