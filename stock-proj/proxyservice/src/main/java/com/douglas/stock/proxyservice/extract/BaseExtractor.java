package com.douglas.stock.proxyservice.extract;

import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import cn.edu.hfut.dmic.webcollector.util.RegexRule;

import java.util.List;

/**
 * Created by wgz on 15/4/3.
 */
public class BaseExtractor {
    public List extract(String url) {
        Links links = new Links();
        Page page = new Page();
        page.setUrl(url);
        HttpResponse response = PageCrawler.crawl(url, null, 10000, 10000, 3);
        if (response == null) {
            return links;
        }
        page.setResponse(response);
        RegexRule rules = new RegexRule();
        rules.addPositive(url + "(\\d){4}.html");
        links.addAllFromDocument(page.getDoc(), rules);
        return links;
    }
}
