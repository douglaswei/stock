package com.douglas.stock.proxyservice.extract.dl;

import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import cn.edu.hfut.dmic.webcollector.util.RegexRule;
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
 * Date:    16/6/24
 * Time:    下午11:55
 * Desc:
 */
public class YDL extends BaseSpout {

    private Pattern p = Pattern.compile("(\\d{1,3}\\.\\d{1,3}.\\d{1,3}.\\d{1,3}):(\\d+)@(HTTP|SOCKS)");

    public YDL(BlockingQueue<EnhancedProxy> proxies) {
        super(proxies);

        seeds = Lists.newArrayList(
                "http://www.youdaili.net/Daili/http/",
                "http://www.youdaili.net/Daili/guonei/",
                "http://www.youdaili.net/Daili/guowai/");
    }

    public List extract(String url) {
        Links links = new Links();
        Page page = new Page();
        page.setUrl(url);
        HttpResponse response = PageCrawler.crawl(url, null, 10000, 10000, true, 3);
        if (response == null) {
            return links;
        }
        page.setResponse(response);
        RegexRule rules = new RegexRule();
        rules.addPositive(url + "(\\d){4}.html");
        links.addAllFromDocument(page.getDoc(), rules);
        return links;
    }

    @Override
    public List<String> extractLinks(String url) {
        List links = extract(url);
        if (links == null) {
            return null;
        }

        Links resLinks = new Links();

        for (Object linkObj : links) {
            String link = (String) linkObj;
            resLinks.add(link);

            for (int idx = 2; idx < 20; ++idx) {
                String newLink = link.replace(".html", "_" + String.valueOf(idx) + ".html");
                resLinks.add(newLink);
            }
        }

        return resLinks;
    }

    @Override
    public void extractProxies(String url) throws InterruptedException {
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
                String sType = m.group(3);
                Proxy.Type type = sType.compareToIgnoreCase("HTTP") == 0 ? Proxy.Type.HTTP : Proxy.Type.SOCKS;
                EnhancedProxy proxy = new EnhancedProxy(type, new InetSocketAddress(host, port), 0);
                proxies.put(proxy);
            }
        }
    }

}
