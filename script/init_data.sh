#! /bin/sh


. script/common.sh

LOCAL_SETTING_FILE="./crawler/local_settings.py"
LOCAL_SETTING_FILE_BK=$LOCAL_SETTING_FILE".bk"

# back local_setting


cd crawler
cp $LOCAL_SETTING_FILE $LOCAL_SETTING_FILE_BK

for idx in `seq 1000`
do
    execute sed -i "s/^DATEDIFF.*$/DATEDIFF=${idx}/" $LOCAL_SETTING_FILE
    execute scrapy crawl stock_bestgo
done

execute scrapy crawl stock_ifeng

cp $LOCAL_SETTING_FILE_BK $LOCAL_SETTING_FILE

# get all history data

# restore config
