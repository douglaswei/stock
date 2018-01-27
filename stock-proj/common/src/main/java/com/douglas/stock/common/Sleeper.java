package com.douglas.stock.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

/**
 * Created by wgz on 15/4/1.
 */
public class Sleeper {
    private final static Logger logger = LoggerFactory.getLogger(Sleeper.class);

    @Value("${sleeper.defaultMs}")
    private Integer defaultMs;

    @Value("${sleeper.randomWait}")
    private boolean randomWait;

    private Random randomSeed = new Random();

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
            return defaultMs;
        }
        String host = url.getHost();
        Integer ms = defaultMs;
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
