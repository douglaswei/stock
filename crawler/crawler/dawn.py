#!/usr/bin/python
#coding=utf-8
import urllib, urllib2, cookielib
import socket
import time
from scrapy import log


class Dawn:
    timeout = 30

    def __init__(self):
        httpHandler = urllib2.HTTPHandler()
        httpsHandler = urllib2.HTTPSHandler()
        cookie = cookielib.CookieJar()
        cookie_support = urllib2.HTTPCookieProcessor(cookie)
        opener = urllib2.build_opener(cookie_support, httpHandler, httpsHandler)
        urllib2.install_opener(opener)

    def getHeader(self):
        header = {
            "User-Agent":"Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13",
            "Accept":"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
            "Accept-Language":"zh-cn,zh;q=0.5",
            "Accept-Charset":"GB2312,utf-8;q=0.7,*;q=0.7",
            "Keep-Alive":"115",
            "Connection":"keep-alive"
            }

        return header

    def request(self, url, data, headers=None):
        '''
        data = {'act' : 'allsym',
                'q' : '%u5934%u90E8',
                'sex' : '\u6027\u522b\u5f\u7537', 
                'age' : '%u75BE%u75C5%u5E74%u9F84_%u58EE%u5E74%uFF0830%7E39%u5C81%uFF09',
                'jid' : '13'}
        '''

        if headers is None:
            header = self.getHeader()

        #开始设置请求数据
        req = urllib2.Request(
            url = url,
            headers = header
            )
        if data is not None:
            data = urllib.urlencode(data)

        #请求开始
        try:
            #socket.setdefaulttimeout(60)
            request = urllib2.urlopen(req, data, self.timeout)
            #请求无结果，休眠后再请求一次
            if request is None or request == 'None':
                #time.sleep(10)
                request = urllib2.urlopen(req, data, self.timeout)

            source = request.read()
            #request.close()

            #返回的结果集转码
            source_gbk = source.decode('GBK')
            source = source_gbk.encode('utf-8')
        except Exception,ex:
            log.msg(ex, level=log.DEBUG)
            source = None
            #print "connect faild..."
       

            
        return source

'''
if __name__ == "__main__":
    dawn = Dawn()
    result = dawn.request("http://jbk.39.net/SelfDiagnosis/DiagnosisHandler.ashx")

    fo = open('/Users/dmiy/Downloads/result.json', 'w')
    fo.write(result)
    fo.close()
    print result
'''
