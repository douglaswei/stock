package com.douglas.stock.common.job;

import com.douglas.stock.common.Config;
import com.douglas.stock.common.dao.DBRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Created by wgz on 15/4/10.
 */
public class BasicJob extends Thread {
    private Logger logger = LoggerFactory.getLogger("Job");

    protected String processorClassName;
    protected int threadNum = 40;
    protected BlockingQueue inputQueue;
    protected BlockingQueue outputQueue;
    private DBRecordService service;

    public DBRecordService getService() {
        return service;
    }

    public void setService(DBRecordService service) {
        this.service = service;
    }

    public String getProcessorClassName() {
        return processorClassName;
    }

    public void setProcessorClassName(String processorClassName) {
        this.processorClassName = processorClassName;
    }

    public int getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(int threadNum) {
        this.threadNum = threadNum;
    }

    public BlockingQueue getInputQueue() {
        return inputQueue;
    }

    public void setInputQueue(BlockingQueue inputQueue) {
        this.inputQueue = inputQueue;
    }

    public BlockingQueue getOutputQueue() {
        return outputQueue;
    }

    public void setOutputQueue(BlockingQueue outputQueue) {
        this.outputQueue = outputQueue;
    }

    public void run() {
        Date begTime = new Date();
        logger.info("[{}] beg at [{}]", processorClassName, begTime);

        try {
            calc();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            logger.warn("exception,", e);
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.warn("exception,", e);
        } catch (InstantiationException e) {
            e.printStackTrace();
            logger.warn("exception,", e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            logger.warn("exception,", e);
        }

        Date endTime = new Date();
        logger.info("[{}] end at [{}]", processorClassName, endTime);
        logger.info("[{}] total time [{}] sec", processorClassName,
                ((double)endTime.getTime() - begTime.getTime()) / 1000);
    }

    public void calc()
            throws ClassNotFoundException, IllegalAccessException, InstantiationException, InterruptedException {
        Class processorClass = Class.forName(processorClassName);

        // create processors & set queues & run processors
        List processors = new ArrayList();
        for (int idx = 0; idx < threadNum; ++idx) {

            // create processor
            BasicProcessor processor = (BasicProcessor) processorClass.newInstance();
            if (processor == null) {
                return;
            }

            // init queue, which is legal to be null
            processor.setInQueue(inputQueue);
            processor.setOutQueue(outputQueue);

            // run processors in threads
            processors.add(processor);
            processor.start();
        }

        // join processors
        for (Object processor : processors) {
            ((BasicProcessor)processor).join();
        }

        // add Terminators
        if (outputQueue != null) {
            for (int idx = 0; idx < Config.getMaxThreadNum(); ++idx) {
                outputQueue.put(new JobTernimator());
            }
        }
    }

    /**
     * Created by wgz on 15/4/4.
     */
    public static class JobTernimator {
    }
}
