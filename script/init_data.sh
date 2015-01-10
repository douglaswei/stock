#! /bin/sh


. script/common.sh

LOCAL_SETTING_FILE="./crawler/local_settings.py"
LOCAL_SETTING_FILE_BK=$LOCAL_SETTING_FILE".bk"

# back local_setting


cd crawler
cp $LOCAL_SETTING_FILE $LOCAL_SETTING_FILE_BK

execute sed -i "s/^DATE_SPAN.*$/DATE_SPAN=1000/" $LOCAL_SETTING_FILE
execute scrapy crawl stock_bestgo

#execute scrapy crawl stock_ifeng

cp $LOCAL_SETTING_FILE_BK $LOCAL_SETTING_FILE

# get all history data

# restore config
