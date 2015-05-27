package com.douglas.stock.dataprepare.job.processor;

import com.douglas.stock.common.Config;
import com.douglas.stock.common.dao.DBRecordService;
import com.douglas.stock.common.job.ProcessorUseOutput;

/**
 * Created by wgz on 15/4/10.
 */
public class T_Code extends ProcessorUseOutput {

    @Override
    protected void calc() throws InterruptedException {
        for (String code : Config.getService().getCodes()) {
            getOutQueue().put(code);
        }
    }
}
