package com.douglas.stock.proxyservice.extract;

import com.douglas.stock.proxyservice.aop.TimeInfo;
import com.douglas.stock.proxyservice.bean.EnhancedProxy;
import com.douglas.stock.proxyservice.extract.dl.BaseSpout;
import com.douglas.stock.proxyservice.extract.dl.KDL;
import com.douglas.stock.proxyservice.extract.dl.YDL;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by wgz on 15/4/3.
 */
@Configuration
public class ProxyGenerator {
    private final static Logger logger = LoggerFactory.getLogger(ProxyGenerator.class);
    private static Random random = new Random();

    @Autowired
    private ProxyValidator proxyValidator;

    @Value("${consumerNum:500}")
    private int consumerNum;
    private BlockingDeque<EnhancedProxy> proxiesQueue;
    private Set<EnhancedProxy> proxyRes;
    private List<EnhancedProxy> proxyList;
    @Value("${connectTimeout:3000}")
    private int connectTimeout;
    @Value("${readTimeout:5000}")
    private int readTimeout;
    @Value("${validInterval:5000}")
    private int validInterval;
    @Value("${proxyReuseInterval:4000}")
    private int proxyReuseInterval;

    public ProxyGenerator() {
    }

    public int getConsumerNum() {
        return consumerNum;
    }

    public void setConsumerNum(int consumerNum) {
        this.consumerNum = consumerNum;
    }

    public BlockingDeque<EnhancedProxy> getProxiesQueue() {
        return proxiesQueue;
    }

    public void setProxiesQueue(BlockingDeque<EnhancedProxy> proxiesQueue) {
        this.proxiesQueue = proxiesQueue;
    }

    public Set<EnhancedProxy> getProxyRes() {
        return proxyRes;
    }

    public void setProxyRes(Set<EnhancedProxy> proxyRes) {
        this.proxyRes = proxyRes;
    }

    public List<EnhancedProxy> getProxyList() {
        return proxyList;
    }

    public void setProxyList(List<EnhancedProxy> proxyList) {
        this.proxyList = proxyList;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public int getValidInterval() {
        return validInterval;
    }

    public void setValidInterval(int validInterval) {
        this.validInterval = validInterval;
    }

    public int getProxyReuseInterval() {
        return proxyReuseInterval;
    }

    public void setProxyReuseInterval(int proxyReuseInterval) {
        this.proxyReuseInterval = proxyReuseInterval;
    }

    @TimeInfo
    @Scheduled(fixedDelay = 12 * 60 * 60 * 1000)
    public synchronized void run() throws InterruptedException {
        BlockingDeque<EnhancedProxy> newProxyQueue = new LinkedBlockingDeque<EnhancedProxy>();
        Set<EnhancedProxy> newProxyRes = new HashSet<>();
        proxiesQueue = newProxyQueue;
        proxyRes = newProxyRes;

        // start consumer
        List<Consumer> consumers = new ArrayList<Consumer>();
        for (int idx = 0; idx < consumerNum; ++idx) {
            Consumer consumer = new Consumer();
            consumers.add(consumer);
            consumer.start();
        }

        // start spout list
        ArrayList<BaseSpout> spoutList = Lists.newArrayList(
//                new KDL(proxiesQueue),
//                new YDL(proxiesQueue)
        );


        spoutList.clear();
        spoutList.add(new KDL(proxiesQueue));

        for (BaseSpout spout : spoutList) {
            spout.start();
        }

        // join spout list
        for (BaseSpout spout : spoutList) {
            spout.join();
        }

        // push end nodes
        EnhancedProxy endProxy = new EnhancedProxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 0), 0);
        endProxy.setValid(false);
        for (int idx = 0; idx < consumerNum; ++idx) {
            proxiesQueue.put(endProxy);
        }

        // join consumers
        for (Consumer consumer : consumers) {
            consumer.join();
        }
        setProxyList(new ArrayList<EnhancedProxy>(proxyRes));
        logger.info("finish try all proxies, final: [{}]", proxyRes.size());
    }

    public EnhancedProxy getForUse() {
        List<EnhancedProxy> proxies = getProxyList();
        int idx = 0;
        while (true) {
            if (proxies.size() == 0) {
                return null;
            }
            synchronized (random) {
                idx = random.nextInt(proxies.size());
                logger.info("try {} proxy", idx);
            }
            synchronized (proxies) {
                while (true) {
                    EnhancedProxy proxy = proxies.get(idx);
                    if (isProxyUsable(proxy)) {
                        return proxy;
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        return null;
                    }
                }
            }
        }
    }

    private boolean isProxyUsable(EnhancedProxy proxy) {
        synchronized (proxy) {
            Date last = proxy.getLast();
            Date now = new Date();
            if (proxy.getLast() == null || now.getTime() - proxy.getLast().getTime() >= getProxyReuseInterval()) {
                last = now;
                proxy.setLast(now);
                return true;
            }
            return false;
        }
    }

    private class Consumer extends Thread {
        public void run() {
            while (true) {
                try {
                    EnhancedProxy proxy = proxiesQueue.take();
                    if (!proxy.isValid()) {
                        return;
                    }
                    if (proxyRes.contains(proxy)) {
                        continue;
                    }
                    int interval = proxyValidator.validate(proxy, connectTimeout, readTimeout, validInterval);
                    if (interval >= 0) {
                        synchronized (proxyRes) {
                            if (proxyRes != null) {
                                proxyRes.add(proxy);
                                logger.info("add proxy: {}", proxy);
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}
