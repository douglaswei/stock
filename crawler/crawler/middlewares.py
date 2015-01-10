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

FREE_PROXY_FILE = "free_proxy.txt"
FREE_PROXY_FILE_TOUCH = "./free_proxy.txt.touch"


class ProxyMiddleware(object):
    proxy_list = [
        ]

    time_recorder = 0


    def __init__(self):
        for line in open(FREE_PROXY_FILE):
            log.msg('add proxy:' + line[:-1])
            self.__class__.proxy_list.append(line[:-1])

    # overwrite process request
    def process_request(self, request, spider):
        # Set the location of the proxy
        while True:
            if self.need_reload_proxy():
                self.reload_proxy()
            if len(self.__class__.proxy_list) == 0:
                log.msg('no proxy, sleep for a moment', level=log.DEBUG)
                time.sleep(1)
                continue
            random_proxy = random.choice(self.__class__.proxy_list)
            log.msg("[url] [" + request.url +"] [proxy|" + random_proxy + "]", level=log.DEBUG)
            request.meta['proxy'] = random_proxy
            break


    def need_reload_proxy(self):
        # if no file , do not reload
        if not os.path.exists(FREE_PROXY_FILE_TOUCH):
            return False
        # not loaded yet, need reload
        if (self.__class__.time_recorder == 0):
            return True
        # if the file is not updated, do not reload
        cur_time = os.path.getmtime(name)
        if cur_time > self.__class__.time_recorder:
            return True
        else:
            return False


    def reload_proxy(self):
        log.msg("reload proxy", level=log.DEBUG)
        for line in open(FREE_PROXY_FILE):
            line = line[0:-1]
            if not line in proxy_list:
                self.__class__.proxy_list.append(line)
        cur_time = os.path.getmtime(name)
        self.__class__.time_recorder = cur_time
    

