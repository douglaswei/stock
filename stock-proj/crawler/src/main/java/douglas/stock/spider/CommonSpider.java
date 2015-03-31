package douglas.stock.spider;


import cn.edu.hfut.dmic.webcollector.crawler.DeepCrawler;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.util.RegexRule;
import douglas.stock.spider.Seed.SeedManager;
import douglas.stock.spider.pageprocess.BasicPageProcessor;
import douglas.stock.spider.writer.RecorderWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

/**
 * Created by wgz on 15/3/27.
 */
public class CommonSpider extends DeepCrawler {
    private static final Logger logger = LoggerFactory.getLogger(CommonSpider.class);
    private RegexRule rule;
    private Map<String, BasicPageProcessor> processorHashMap;
    private int msWaitBeforeReturnLinks = 10;
    private boolean randomWait = false;
    private Random randomRatio = new Random();
    private List<RecorderWriter> recorderWriters;
    private SeedManager seedManager;

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

    public int getMsWaitBeforeReturnLinks() {
        return msWaitBeforeReturnLinks;
    }

    public void setMsWaitBeforeReturnLinks(int msWaitBeforeReturnLinks) {
        this.msWaitBeforeReturnLinks = msWaitBeforeReturnLinks;
    }

    public boolean isRandomWait() {
        return randomWait;
    }

    public void setRandomWait(boolean randomWait) {
        this.randomWait = randomWait;
    }

    public List<RecorderWriter> getRecorderWriters() {
        return recorderWriters;
    }

    public void setRecorderWriters(List<RecorderWriter> recorderWriters) {
        this.recorderWriters = recorderWriters;
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
        List<Record> records = null;
        for (String pattern: processorHashMap.keySet()) {
            if (page.getUrl().matches(pattern)) {
                records = processorHashMap.get(pattern).process(page);
                break;
            }
        }

        for (RecorderWriter recorderWriter : recorderWriters) {
            recorderWriter.save(records);
        }

        int waitMs = getMsWaitBeforeReturnLinks();
        if (randomWait) {
            int ratio = randomRatio.nextInt();
            double dr = (ratio % 100) + 50;
            waitMs *= (dr / 100);
        }
        try {
            Thread.sleep(waitMs);
        } catch (InterruptedException e) {
            logger.error("{}", e);
            logger.error("{}", e);
        }
        return links;
    }

    public static void main(String[] args) throws Exception {
        CommonSpider spider = new CommonSpider("test");
        spider.addSeed("http://www.bestgo.com/fund/");
        spider.setThreads(1);
        spider.start(2^10);
    }

}
