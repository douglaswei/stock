# -*- coding: utf-8 -*-

# Scrapy settings for crawler project
#
# For simplicity, this file contains only the most important settings by
# default. All the other settings are documented here:
#
#     http://doc.scrapy.org/en/latest/topics/settings.html
#

BOT_NAME = 'crawler'

SPIDER_MODULES = ['crawler.spiders']
NEWSPIDER_MODULE = 'crawler.spiders'

DOWNLOADER_MIDDLEWARES = {
    'crawler.middlewares.ProxyMiddleware': None,
    'crawler.random_user_agent.RandomUserAgentMiddleware': 200,
    'scrapy.contrib.downloadermiddleware.useragent.UserAgentMiddleware': None,
    'scrapy.contrib.downloadermiddleware.retry.RetryMiddleware': 1000,
}

ITEM_PIPELINES = {
    'crawler.pipelines.IfengPipeline': None,
    'crawler.pipelines.BestgoPipeline': 400,
    'crawler.pipelines.CatePipeline': 500,
    'crawler.pipelines.DumpFilePipeline' : 600,
}


RANDOMIZE_DOWNLOAD_DELAY = True
COOKIES_ENABLED = True
ROBOTSTXT_OBEY = True

CONCURRENT_REQUESTS = 100
CONCURRENT_ITEMS = 100
CONCURRENT_REQUESTS_PER_DOMAIN = 100
DOWNLOAD_TIMEOUT = 50
DOWNLOAD_DELAY = 0.05

# 3.5 G max memory for use
MEMUSAGE_LIMIT_MB = 3500

RETRY_TIMES = 10
RETRY_HTTP_CODES = [500, 502, 503, 504, 400, 408, 404, 302, 403]

LOG_LEVEL = 'DEBUG'
LOG_FILE = 'log'

# Crawl responsibly by identifying yourself (and your website) on the user-agent
#USER_AGENT = 'crawler (+http://www.yourdomain.com)'
