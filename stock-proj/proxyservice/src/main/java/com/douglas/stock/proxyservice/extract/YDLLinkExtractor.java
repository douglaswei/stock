package com.douglas.stock.proxyservice.extract;

import cn.edu.hfut.dmic.webcollector.model.Links;

import java.util.List;

/**
 * Created by wgz on 15/4/3.
 */
public class YDLLinkExtractor extends BaseExtractor {
    @Override
    public List extract(String url) {
        List links = super.extract(url);
        String resLink = null;
        if (links == null) {
            return null;
        }
        for (Object link : links) {
            String slink = (String)link;
            if (slink.indexOf(url)==0 && (resLink == null || resLink.compareTo(slink) < 0)) {
                resLink = slink;
            }
        }
        Links resLinks = new Links();
        if (resLink == null) {
            return resLinks;
        }
        for (int idx = 2; idx < 20; ++idx) {
            String newLink = resLink.replace(".html", "_"+String.valueOf(idx)+".html");
            resLinks.add(newLink);
        }
        return resLinks;
    }
}
