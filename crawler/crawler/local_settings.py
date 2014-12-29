# -*- coding: utf-8 -*-

# local settings for crawler project
#
#
#

from datetime import date
from datetime import timedelta

DATEDIFF=0
DESIRED_DATE_STR=(date.today() - timedelta(days=DATEDIFF)).strftime('%Y%m%d')
TODAY_STR=(date.today()).strftime('%Y%m%d')

STOCK_CODES_BLACKLIST=[
]

STOCK_DATA_DIR="../data/crawl_data/"

DUMP_FILENAME="../data/dump"

