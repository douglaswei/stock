package com.douglas.stock.proxyservice.extract.dl;

import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import com.douglas.stock.common.PageCrawler;
import com.douglas.stock.proxyservice.bean.EnhancedProxy;
import com.google.common.collect.Lists;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author:  wgz
 * Date:    16/6/25
 * Time:    上午12:05
 * Desc:
 */
public class XICI extends BaseSpout{

    private Pattern p = Pattern.compile("(\\d{1,3}\\.\\d{1,3}.\\d{1,3}.\\d{1,3})</td>[\\S\\s]+<td>(\\d+)(</td>[\\s\\S]+){2}(HTTP|HTTPS|socks)");

    public XICI(BlockingQueue<EnhancedProxy> proxies) {
        super(proxies);

        seeds = Lists.newArrayList(
                "http://www.xicidaili.com/nn/",
                "http://www.xicidaili.com/nt/",
                "http://www.xicidaili.com/wn/");
    }

    @Override
    public List<String> extractLinks(String url) {

        Links resLinks = new Links();
        resLinks.add(url);

        for (Integer idx = 2; idx < 200; ++idx) {
            resLinks.add(url + String.valueOf(idx));
        }

        return resLinks;
    }

    @Override
    public void extractProxies(String url) throws InterruptedException {
        Thread.sleep(1500);
        HttpResponse response = PageCrawler.crawl(url, null, 10000, 10000, true, 3);
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
