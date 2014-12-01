#! /bin/sh


LOCAL_SETTING_FILE="./crawler/local_settings.py"
LOCAL_SETTING_FILE_BK=$LOCAL_SETTING_FILE".bk"

# back local_setting

execute()
{
    echo $@
    `$@`
}

cd crawler
cp $LOCAL_SETTING_FILE $LOCAL_SETTING_FILE_BK

for i in {1..712}
do
    DATE=`date -v -${i}d +%Y%m%d`
    execute sed -i ".b" "s/^DESIRED_DATE_STR.*$/DESIRED_DATE_STR='${DATE}'/" $LOCAL_SETTING_FILE
    execute scrapy crawl stock_bestgo
done

execute scrapy crawl stock_ifeng

cp $LOCAL_SETTING_FILE_BK $LOCAL_SETTING_FILE

# get all history data

# restore config
