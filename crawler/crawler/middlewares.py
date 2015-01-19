#!/usr/bin/python
#coding utf-8
#****************************************************************#
# ScriptName: tutorial/middlewares.py
# Create Date: 2014-06-18 14:39
# Modify Date: 2014-06-18 14:39
#***************************************************************#

import base64
import random
from scrapy import log
import urllib2
import re
import time
import os

from datetime import datetime

from local_settings import FREE_PROXY_FILE, FREE_PROXY_FILE_TOUCH


class ProxyMiddleware(object):
    proxy_list = [
        ]

    time_recorder = 0

    def __init__(self):
        for line in open(FREE_PROXY_FILE):
            log.msg('add proxy:' + line[:-1])
            self.proxy_list.append(line[:-1])
            self.proxy_dict = {}

    # overwrite process request
    def process_request(self, request, spider):
        # Set the location of the proxy
        while True:
            if self.need_reload_proxy():
                self.reload_proxy()
            if len(self.proxy_list) == 0:
                log.msg('no proxy, sleep for a moment', level=log.DEBUG)
                time.sleep(0.5)
                continue
            random_proxy = random.choice(self.proxy_list)
            prev_time =  self.proxy_dict.get(random_proxy, None)
            cur_time = datetime.today()
            if prev_time is not None:
                diff = cur_time - prev_time
                if diff.total_seconds() < 5:
                    time.sleep(0.1)
                    continue

            self.proxy_dict[random_proxy] = cur_time
            log.msg("[url] [" + request.url +"] [proxy|" + random_proxy + "]", level=log.DEBUG)
            request.meta['proxy'] = random_proxy
            break


    def need_reload_proxy(self):
        # if no file , do not reload
        if not os.path.exists(FREE_PROXY_FILE_TOUCH):
            return False
        # not loaded yet, need reload
        if (self.time_recorder == 0):
            return True
        # if the file is not updated, do not reload
        cur_time = os.path.getmtime(name)
        if cur_time > self.time_recorder:
            return True
        else:
            return False


    def reload_proxy(self):
        log.msg("reload proxy", level=log.DEBUG)
        for line in open(FREE_PROXY_FILE):
            line = line[0:-1]
            if not line in proxy_list:
                self.proxy_list.append(line)
        cur_time = os.path.getmtime(name)
        self.time_recorder = cur_time
    

