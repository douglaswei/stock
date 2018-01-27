package com.douglas.stock.common;

import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import cn.edu.hfut.dmic.webcollector.net.Proxys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by wgz on 15/4/2.
 */
public class PageCrawler {

    private final static Logger LOG = LoggerFactory.getLogger(PageCrawler.class);

    private static Random random = new Random();
    private static List<String> agents = new ArrayList<String>();

    static {
        agents.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/22.0.1207.1 Safari/537.1");
        agents.add("Mozilla/5.0 (X11; CrOS i686 2268.111.0) AppleWebKit/536.11 (KHTML, like Gecko) Chrome/20.0.1132.57 Safari/536.11");
        agents.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.6 (KHTML, like Gecko) Chrome/20.0.1092.0 Safari/536.6");
        agents.add("Mozilla/5.0 (Windows NT 6.2) AppleWebKit/536.6 (KHTML, like Gecko) Chrome/20.0.1090.0 Safari/536.6");
        agents.add("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/19.77.34.5 Safari/537.1");
        agents.add("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/536.5 (KHTML, like Gecko) Chrome/19.0.1084.9 Safari/536.5");
        agents.add("Mozilla/5.0 (Windows NT 6.0) AppleWebKit/536.5 (KHTML, like Gecko) Chrome/19.0.1084.36 Safari/536.5");
        agents.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1063.0 Safari/536.3");
        agents.add("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1063.0 Safari/536.3");
        agents.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_0) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1063.0 Safari/536.3");
        agents.add("Mozilla/5.0 (Windows NT 6.2) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1062.0 Safari/536.3");
        agents.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1062.0 Safari/536.3");
        agents.add("Mozilla/5.0 (Windows NT 6.2) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1061.1 Safari/536.3");
        agents.add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1061.1 Safari/536.3");
        agents.add("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1061.1 Safari/536.3");
        agents.add("Mozilla/5.0 (Windows NT 6.2) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1061.0 Safari/536.3");
        agents.add("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.24 (KHTML, like Gecko) Chrome/19.0.1055.1 Safari/535.24");
        agents.add("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/535.24 (KHTML, like Gecko) Chrome/19.0.1055.1 Safari/535.24");
    }

    public static HttpResponse crawl(String url, Proxy proxy, int connectTimeout, int readTimeout, boolean logWarn, int retry) {
        return crawl(url, proxy, connectTimeout, readTimeout, null, logWarn, retry);
    }

    public static HttpResponse crawl(String url, Proxy proxy, int connectTimeout, int readTimeout, Map<String, String> headers, boolean logWarn, int retry) {
        CommonHttpRequester requester = new CommonHttpRequester();
        requester.setConnectTimeOut(connectTimeout);
        requester.setReadTimeOut(readTimeout);
        String cookieStr = "visid_incap_257263=hZZ3rUrvR/KT2aNAKs1ZjenToFQAAAAAQUIPAAAAAACG3nnf+LUrto9yxcfpc0X0; incap_ses_199_257263=N1o/ZjuMQW0XAs8DUx7DAunToFQAAAAABioeTfdjm85Vqxm+me0aXA==";
        requester.setCookie(cookieStr);
        requester.setHeaders(headers);

        if (agents != null && agents.size() != 0) {
            requester.setUserAgents(agents);
        }
        if (proxy != null) {
            Proxys proxies = new Proxys();
            proxies.add(proxy);
            requester.setProxys(proxies);
        }
        HttpResponse response = null;
        try {
            response = requester.getResponse(url);
        } catch (Exception e) {
            if (retry > 0) {
                return crawl(url, proxy, connectTimeout, readTimeout, headers, logWarn, retry - 1);
            }
            if (logWarn) {
                LOG.warn("fail to crawl [{}]", url);
            }
            return null;
        }
        if (response == null) {
            if (retry > 0) {
                return crawl(url, proxy, connectTimeout, readTimeout, headers, logWarn, retry - 1);
            }
            if (logWarn) {
                LOG.warn("fail to crawl [{}]", url);
            }
        }



        return response;
    }
}
