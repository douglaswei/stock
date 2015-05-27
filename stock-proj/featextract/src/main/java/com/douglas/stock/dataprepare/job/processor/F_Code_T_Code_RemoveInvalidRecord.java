package com.douglas.stock.dataprepare.job.processor;

import com.douglas.stock.common.Config;
import com.douglas.stock.common.dao.DBRecordService;
import com.douglas.stock.common.job.ProcessorUseInput;
import com.douglas.stock.common.job.ProcessResult;

/**
 * Created by wgz on 15/4/10.
 */
public class F_Code_T_Code_RemoveInvalidRecord extends ProcessorUseInput {
    public F_Code_T_Code_RemoveInvalidRecord() {
        inputClass = String.class;
    }

    @Override
    protected ProcessResult calc(Object object) throws InterruptedException {
        String code = (String) object;
        Config.getService().removeInvalidRecords((String) code);
        if (getOutQueue() != null) {
            getOutQueue().put(object);
        }
        return ProcessResult.SUCCESS;
    }
}
