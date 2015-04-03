package com.douglas.stock.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by wgz on 15/4/1.
 */
public class Sleeper {
    private final static Logger logger = LoggerFactory.getLogger(Sleeper.class);
    private int dftMs = 10;
    private HashMap<String, Integer> domainMsMap;
    private boolean randomWait = false;
    private Random randomSeed = new Random();

    public int getDftMs() {
        return dftMs;
    }

    public void setDftMs(int dftMs) {
        this.dftMs = dftMs;
    }

    public HashMap<String, Integer> getDomainMsMap() {
        return domainMsMap;
    }

    public void setDomainMsMap(HashMap<String, Integer> domainMsMap) {
        this.domainMsMap = domainMsMap;
    }

    public void sleepByUrl(String httpUrl) {
        try {
            int ms = getSleepTimeByUrl(httpUrl);
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            logger.error("exception:", e);
        }
    }

    public int getSleepTimeByUrl(String httpUrl) {
        URL url = null;
        try {
            url = new URL(httpUrl);
        } catch (MalformedURLException e) {
            logger.error("exception:", e);
            return getDftMs();
        }
        String host = url.getHost();
        Integer ms = getDftMs();
        if (domainMsMap != null) {
            ms = domainMsMap.get(host);
        }
        if (ms == null) {
            ms = getDftMs();
        }
        ms = (int)(ms * nextRandom());
        return ms;
    }

    private double nextRandom() {
        double ran = 1.0;
        if (randomWait) {
            double percent = randomSeed.nextInt(60) + 70;
            ran *= (percent / 100);
        }
        return ran;
    }

}
