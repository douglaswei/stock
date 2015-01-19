# -*- coding: utf-8 -*-

# local settings for crawler project
#
#
#

from datetime import date
from datetime import timedelta

DATE_BEGIN=0
DATE_SPAN=2
DESIRED_DATES = []
for i in range(DATE_SPAN):
    date_string = (date.today() - timedelta(days=DATE_BEGIN + i)).strftime('%Y%m%d')
    DESIRED_DATES.append(date_string)

TODAY_STR=(date.today()).strftime('%Y%m%d')

STOCK_CODES_BLACKLIST=[
]

STOCK_DATA_DIR="../data/crawl_data/"

DUMP_FILENAME="../data/dump"

FREE_PROXY_FILE = "free_proxy.txt"
FREE_PROXY_FILE_TOUCH = "./free_proxy.txt.touch"

class SHDJT_CONFIFG():
    crawl_whole = False
