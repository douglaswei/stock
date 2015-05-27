package com.douglas.stock.common.job;

import com.douglas.stock.common.job.BasicProcessor;

/**
 * Created by wgz on 15/4/10.
 */
public abstract class ProcessorUseOutput extends BasicProcessor {
    @Override
    protected void calcWithCheck() throws InterruptedException {
        if (getOutQueue() == null) {
            throw new IllegalArgumentException("null output Queue");
        }
        calc();
    }

    protected abstract void calc () throws InterruptedException ;
}
