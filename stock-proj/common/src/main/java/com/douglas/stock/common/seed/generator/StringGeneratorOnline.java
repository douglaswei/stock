package com.douglas.stock.common.seed.generator;

import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import com.douglas.stock.common.CommonHttpRequester;
import com.douglas.stock.common.PageCrawler;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.xsoup.Xsoup;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wgz on 15/4/7.
 */
public class StringGeneratorOnline implements StringGenerator {
    private final static Logger logger = LoggerFactory.getLogger(StringGeneratorOnline.class);
    private int beg = 1;
    private int end = 100;

    public int getBeg() {
        return beg;
    }

    public void setBeg(int beg) {
        this.beg = beg;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public List<String> getStrings() {
        List<String> seeds = new ArrayList<String>();
        List<String> res = null;
        for (int idx = beg; idx <= end; ++idx) {
            String url = String.format("http://quote.stockstar.com/stock/ranklist_a_1_1_%d.html", idx);
            res = getSeedCodes(url);
            if (res != null) {
                seeds.addAll(res);
            }
        }
        return seeds;
    }

    private List<String> getSeedCodes(String url) {
        //CommonHttpRequester requester = new CommonHttpRequester();
        HttpResponse response = PageCrawler.crawl(url, null, 5000, 10000, 10);
        List<String> seeds = new ArrayList<String>();
//        try {
//            response = requester.getResponse(url);
//        } catch (Exception e) {
//            return null;
//        }
        String content = new String(response.getContent());
        Elements elements = Xsoup.select(content, "//tbody[@id='datalist']//td/a").getElements();
        Pattern p = Pattern.compile("(\\d{6})");
        int count = 0;
        for (Element element : elements) {
            Matcher m = p.matcher(element.text());
            if (m.find()) {
                seeds.add(m.group(1));
                logger.info("[{}] get [{}] ", url, m.group(1));
                count++;
            }
        }
        logger.info("[{}] get total {} codes", url, seeds.size());
        return seeds;
    }
}
