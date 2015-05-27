package com.douglas.stock.dataprepare.extract;

import com.douglas.stock.dataprepare.common.RawFeatures;
import com.douglas.stock.dataprepare.common.RecordsTrainPredict;

/**
 * Created by wgz on 15/4/6.
 */
public interface ExtractorInterface {
    public RawFeatures extract(RecordsTrainPredict records);
}
