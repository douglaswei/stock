package com.douglas.stock.proxyservice.extract;

import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import com.douglas.stock.common.PageCrawler;

import java.net.Proxy;
import java.util.Date;

/**
 * Created by wgz on 15/4/2.
 */
public class ProxyValidater {
    private static String url = "http://www.baidu.com";
    public static int validate(Proxy proxy, int connectTimeout, int readTimeout, int vaildInterval) {
        Date beg = new Date();
        HttpResponse response = PageCrawler.crawl(url, proxy, connectTimeout, readTimeout, 0);
        if (response == null) {
            return -1;
        }
        String content = new String(response.getContent());
        Date end = new Date();
        if (content == null || content.indexOf(url) < 0) {
            return -1;
        }
        long interval = end.getTime() - beg.getTime();
        if (interval <= vaildInterval) {
            return (int)interval;
        }
        return -1;
    }
}
