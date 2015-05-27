package com.douglas.stock.dataprepare.job;

import com.douglas.stock.common.Config;
import com.douglas.stock.common.dao.DBRecord;
import com.douglas.stock.common.dao.DBRecordService;
import com.douglas.stock.common.job.BasicJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by wgz on 15/4/5.
 */
public class JobManager {
    public final static Logger logger = LoggerFactory.getLogger(JobManager.class);
    private List<BasicJob> jobLists;
    private int queueSize = 1000;

    public List<BasicJob> getJobLists() {
        return jobLists;
    }

    public void setJobLists(List<BasicJob> jobLists) {
        this.jobLists = jobLists;
    }

    public void execute() throws InterruptedException {
        List<BlockingQueue> queues = new ArrayList<>();
        for (int idx = 0; idx < jobLists.size() + 1; ++idx) {
            queues.add(new ArrayBlockingQueue(queueSize));
        }

        for (int idx = 0; idx < jobLists.size(); ++idx) {
            BasicJob job = jobLists.get(idx);
            job.setInputQueue(queues.get(idx));
            job.setOutputQueue(queues.get(idx+1));
            job.start();
        }

        for (BasicJob job : jobLists) {
            job.join();
        }
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("jobManager.xml");
        JobManager jobManager = (JobManager) applicationContext.getBean("jobManager");
        if (applicationContext.getBean("recordService") != null) {
            Config.setService((DBRecordService) applicationContext.getBean("recordService"));
        }
        if (applicationContext.getBean("featFileName") != null) {
            Config.setFeatFileName((String) applicationContext.getBean("featFileName"));
        }
        if (applicationContext.getBean("labelThresholdUpper") != null) {
            Config.setLabelThresholdUpper((float) applicationContext.getBean("labelThresholdUpper"));
        }
        if (applicationContext.getBean("labelThresholdLower") != null) {
            Config.setLabelThresholdLower((float) applicationContext.getBean("labelThresholdLower"));
        }

        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(Config.getFeatFileName()));
        } catch (IOException e) {
            logger.warn("exception", e);
        }
        Config.setBufferedWriter(bufferedWriter);

        if (jobManager != null) {
            try {
                jobManager.execute();
            } catch (InterruptedException e) {
                logger.error("exception", e);
            }
        }

        if (bufferedWriter != null) {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                logger.warn("exception", e);
            }
        }
    }
}
