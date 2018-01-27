package com.douglas.stock.proxyservice.extract.dl;

import com.douglas.stock.proxyservice.bean.EnhancedProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Author:  wgz
 * Date:    16/6/29
 * Time:    上午11:08
 * Desc:
 */
public class BaseSpout extends Thread {

    protected final static Logger LOG = LoggerFactory.getLogger(BaseSpout.class);

    protected List<String> seeds;

    protected BlockingQueue<EnhancedProxy> proxies;

    public BaseSpout(BlockingQueue<EnhancedProxy> proxies) {
        this.proxies = proxies;
    }

    @Override
    public void run() {
        for (String seed : seeds) {
            List<String> links = extractLinks(seed);
            for (String link : links) {
                try {
                    extractProxies(link);
                } catch (InterruptedException e) {
                    LOG.error(e.toString());
                }
            }
        }
    }

    public List<String> extractLinks(String url) {
        return null;
    }

    public void extractProxies(String url) throws InterruptedException {
    }
}
