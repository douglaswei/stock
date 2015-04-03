package com.douglas.stock.crawler;


import cn.edu.hfut.dmic.webcollector.crawler.DeepCrawler;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.util.RegexRule;
import com.douglas.stock.common.Sleeper;
import com.douglas.stock.common.seed.SeedManager;
import com.douglas.stock.crawler.writer.RecorderWriter;
import com.douglas.stock.crawler.pageprocess.BasicPageProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by wgz on 15/3/27.
 */
public class CommonSpider extends DeepCrawler {
    private static final Logger logger = LoggerFactory.getLogger(CommonSpider.class);
    private SeedManager seedManager;
    private RegexRule rule;
    private Map<String, BasicPageProcessor> processorHashMap;
    private Sleeper sleeper;
    private List<RecorderWriter> writerChain;

    public RegexRule getRule() {
        return rule;
    }

    public void setRule(RegexRule rule) {
        this.rule = rule;
    }

    public Map<String, BasicPageProcessor> getProcessorHashMap() {
        return processorHashMap;
    }

    public void setProcessorHashMap(Map<String, BasicPageProcessor> processorHashMap) {
        this.processorHashMap = processorHashMap;
    }

    public List<RecorderWriter> getWriterChain() {
        return writerChain;
    }

    public void setWriterChain(List<RecorderWriter> writerChain) {
        this.writerChain = writerChain;
    }

    public SeedManager getSeedManager() {
        return seedManager;
    }

    public void setSeedManager(SeedManager seedManager) {
        this.seedManager = seedManager;
        for (String seed : seedManager.getSeeds()) {
            addSeed(seed);
        }
    }

    public Sleeper getSleeper() {
        return sleeper;
    }

    public void setSleeper(Sleeper sleeper) {
        this.sleeper = sleeper;
    }

    public CommonSpider(String crawlPath) {
        super(crawlPath);
        if (seedManager != null) {
            for (String nseed : seedManager.getSeeds()) {
                addSeed(nseed);
            }
        }
    }

    @Override
    public Links visitAndGetNextLinks(Page page) {
        Links links = new Links();
        links.addAllFromDocument(page.getDoc(), rule);
        Set<String> linkSet = new HashSet<>(links);
        Links resLinks = new Links();
        resLinks.addAll(linkSet);
        List<Record> records = null;
        boolean processed = false;
        for (String pattern: processorHashMap.keySet()) {
            if (page.getUrl().matches(pattern)) {
                records = processorHashMap.get(pattern).process(page);
                processed = true;
                break;
            }
        }

        if (!processed) {
            logger.warn("url [{}] no rule to process", page.getUrl());
        }

        if (records != null && writerChain != null) {
            for (RecorderWriter recorderWriter : writerChain) {
                recorderWriter.save(records);
            }
        }

        if (sleeper != null) {
            sleeper.sleepByUrl(page.getUrl());
        }
        for (String link : resLinks) {
            logger.debug("{} --> {}", page.getUrl(), link);
        }
        return resLinks;
    }

    public static void main(String[] args) throws Exception {
        CommonSpider spider = new CommonSpider("test");
        spider.addSeed("http://www.bestgo.com/fund/");
        spider.setThreads(1);
        spider.start(2^10);
    }

}
