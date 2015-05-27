package com.douglas.stock.common.job;

import com.douglas.stock.common.job.BasicJob;
import com.douglas.stock.common.job.BasicProcessor;

/**
 * Created by wgz on 15/4/10.
 */
public abstract class ProcessorUseInput extends BasicProcessor {
    protected Class inputClass;
    private boolean checkClass = true;
    @Override
    protected void calcWithCheck() throws InterruptedException {
        if (getInQueue() == null) {
            throw new IllegalArgumentException("null input Queue");
        }
        calcWithLoop();
    }

    protected void calcWithLoop() throws InterruptedException {
        while (true) {
            Object object = getInQueue().take();
            if (object instanceof BasicJob.JobTernimator) {
                break;
            }
            if (checkClass && inputClass != null && (!inputClass.isInstance(object))) {
                logger.warn("error type, [{}] [{}]", inputClass.getName(), object.getClass().getName());
            }

            ProcessResult result = calc(object);

            if (result == ProcessResult.FAIL) {
                logger.warn("process fail [{}]", result.toString());
            }
        }
    }

    protected abstract ProcessResult calc (Object object) throws InterruptedException;
}
