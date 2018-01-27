package com.douglas.stock.proxyservice.extract.dl;

import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import com.douglas.stock.common.PageCrawler;
import com.douglas.stock.proxyservice.bean.EnhancedProxy;
import com.google.common.collect.Lists;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author:  wgz
 * Date:    16/6/29
 * Time:    上午10:12
 * Desc:
 */
public class KDL extends BaseSpout {

    private Pattern p = Pattern.compile("(\\d{1,3}\\.\\d{1,3}.\\d{1,3}.\\d{1,3})</td>[\\S\\s]+<td data-title=\"PORT\">(\\d+)(</td>[\\s\\S]+){2}(HTTP)");


    public KDL(BlockingQueue<EnhancedProxy> proxies) {
        super(proxies);
        seeds = Lists.newArrayList(
                "http://www.kuaidaili.com/free/inha/",
                "http://www.kuaidaili.com/free/intr/",
                "http://www.kuaidaili.com/free/outha/",
                "http://www.kuaidaili.com/free/outtr/"
        );
    }

    @Override
    public List<String> extractLinks(String url) {
        List links = new ArrayList();
        for (int idx = 1; idx < 1120; ++idx) {
            String link = url + String.valueOf(idx);
            links.add(link);
        }
        return links;
    }

    @Override
    public void extractProxies(String url) throws InterruptedException {
        Map headers = new HashMap();
        headers.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");
        headers.put("Cookie", "Hm_lpvt_7ed65b1cc4b810e9fd37959c9bb51b31=1467362469; Hm_lvt_7ed65b1cc4b810e9fd37959c9bb51b31=1467362457; _ga=GA1.2.1971280969.1467362456; _gat=1");
        HttpResponse response = PageCrawler.crawl(url, null, 10000, 10000, headers, true, 3);
        if (response == null) {
            return;
        }
        String content = new String(response.getContent());
        synchronized (p) {
            Matcher m = p.matcher(content);
            while (m.find()) {
                String host = m.group(1);
                int port = Integer.valueOf(m.group(2));
                String sType = m.group(4);
                Proxy.Type type = sType.indexOf("HTTP") == 0 ? Proxy.Type.HTTP : Proxy.Type.SOCKS;
                EnhancedProxy proxy = new EnhancedProxy(type, new InetSocketAddress(host, port), 0);
                proxies.put(proxy);
            }
        }
    }
}
