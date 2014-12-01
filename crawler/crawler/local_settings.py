# -*- coding: utf-8 -*-

# local settings for crawler project
#
#
#

from datetime import date
from datetime import timedelta

RANDOMIZE_DOWNLOAD_DELAY = True
COOKIES_ENABLED = True

BEGIN_DATE=date.today() - timedelta(days = 712)
END_DATE=date.today() - timedelta(days=1)
DESIRED_DATE_STR=(date.today() - timedelta(days=1)).strftime('%Y%m%d')
#DESIRED_DATE_STR=(date.today() - timedelta(days=1)).strftime('%Y%m%d')
TODAY_STR=(date.today()).strftime('%Y%m%d')

STOCK_CODES_BLACKLIST=[
]

STOCK_DATA_DIR="../data/crawl_data"

