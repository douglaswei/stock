package com.douglas.stock.proxyservice.extract;

import com.douglas.stock.proxyservice.EnhancedProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by wgz on 15/4/3.
 */
public class ProxyGenerator {
    private Logger logger = LoggerFactory.getLogger(ProxyGenerator.class);
    private static ProxyGenerator ourInstance = new ProxyGenerator();
    private static Random random = new Random();

    public static ProxyGenerator getInstance() {
        return ourInstance;
    }

    private ProxyGenerator() {
    }

    private Chain producerChain;
    private int consumerNum = 100;
    private BlockingDeque<EnhancedProxy> proxiesQueue;
    private List<EnhancedProxy> proxyRes;
    private int connectTimeout = 3000;
    private int readTimeout = 5000;
    private int validInterval = 5000;

    public Chain getProducerChain() {
        return producerChain;
    }

    public void setProducerChain(Chain producerChain) {
        this.producerChain = producerChain;
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

    public List<EnhancedProxy> getProxyRes() {
        return proxyRes;
    }

    public void setProxyRes(List<EnhancedProxy> proxyRes) {
        this.proxyRes = proxyRes;
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

    private class Consuemer extends Thread {
        public void run() {
            while (true) {
                try {
                    EnhancedProxy proxy = proxiesQueue.take();
                    if (!proxy.isValid()) {
                        return;
                    }
                    int interval = ProxyValidater.validate(proxy, connectTimeout, readTimeout, validInterval);
                    if (interval >= 0) {
                        proxy.setRespondIntervalMs(interval);
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

    public void run() throws InterruptedException {
        BlockingDeque<EnhancedProxy> newProxyQueue = new LinkedBlockingDeque<EnhancedProxy>();
        List<EnhancedProxy> newProxyRes = new ArrayList<EnhancedProxy>();
        proxiesQueue = newProxyQueue;
        proxyRes = newProxyRes;


        List<Consuemer> consuemers = new ArrayList<Consuemer>();
        for (int idx = 0; idx < consumerNum; ++idx) {
            Consuemer consuemer = new Consuemer();
            consuemers.add(consuemer);
            consuemer.start();
        }

        producerChain = new Chain();
        List<String> seeds = new ArrayList<String>();
        seeds.add("http://www.youdaili.net/Daili/http/");
        seeds.add("http://www.youdaili.net/Daili/guonei/");
        seeds.add("http://www.youdaili.net/Daili/guowai/");
        seeds.add("http://www.youdaili.net/Daili/Socks/");
        producerChain.setSeeds(seeds);
        producerChain.extract(proxiesQueue);

        EnhancedProxy endProxy = new EnhancedProxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 0), 0);
        endProxy.setValid(false);
        for (int idx = 0; idx < consumerNum; ++idx) {
            proxiesQueue.add(endProxy);
        }

        for (Consuemer consuemer : consuemers) {
            consuemer.join();
        }
        logger.info("finish try all proxies");
    }

    public EnhancedProxy getForUse() {
        List<EnhancedProxy> proxies = getProxyRes();
        int idx = 0;
        while (true) {
            synchronized (random) {
                idx = random.nextInt(proxies.size());
            }
            synchronized (proxies) {
                while (true) {
                    EnhancedProxy proxy = proxies.get(idx);
                    if (proxy.useIfUsable()) {
                        return proxy;
                    }
                }
            }
        }
    }
}
