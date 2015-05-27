package com.douglas.stock.common.job;

import com.douglas.stock.common.dao.DBRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

/**
 * Created by wgz on 15/4/10.
 */
public abstract class BasicProcessor extends Thread {
    protected final static Logger logger = LoggerFactory.getLogger(BasicProcessor.class);
    private BlockingQueue inQueue;
    private BlockingQueue outQueue;

    public BlockingQueue getInQueue() {
        return inQueue;
    }

    public void setInQueue(BlockingQueue inQueue) {
        this.inQueue = inQueue;
    }

    public BlockingQueue getOutQueue() {
        return outQueue;
    }

    public void setOutQueue(BlockingQueue outQueue) {
        this.outQueue = outQueue;
    }

    public void run() {
        Date begTime = new Date();
        logger.info("[{}] beg at [{}]", getClass().getName(), begTime);

        try {
            calcWithCheck();
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.warn("[{}], exceptioon, [{}]", getClass().getName(), e.toString());
        }

        Date endTime = new Date();
        logger.info("[{}] end at [{}]", getClass().getName(), endTime);
        logger.info("[{}] total time [{}] sec", getClass().getName(),
                ((double) endTime.getTime() - begTime.getTime()) / 1000);
    }

    protected abstract void calcWithCheck() throws InterruptedException;
}
