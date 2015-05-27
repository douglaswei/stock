package com.douglas.stock.common.job;

/**
 * Created by wgz on 15/4/10.
 */
public abstract class ProcessorUseInputOutput extends ProcessorUseInput {
    @Override
    protected void calcWithCheck() throws InterruptedException {
        if (getInQueue() == null || getOutQueue() == null) {
            throw new IllegalArgumentException("null input or output Queue");
        }
        calcWithLoop();
    }
}
