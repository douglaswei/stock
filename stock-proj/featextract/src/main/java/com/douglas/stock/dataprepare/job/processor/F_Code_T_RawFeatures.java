package com.douglas.stock.dataprepare.job.processor;

import com.douglas.stock.common.Config;
import com.douglas.stock.common.dao.DBRecord;
import com.douglas.stock.common.job.ProcessResult;
import com.douglas.stock.common.job.ProcessorUseInput;
import com.douglas.stock.dataprepare.common.RawFeatures;
import com.douglas.stock.dataprepare.common.RecordsTrainPredict;
import com.douglas.stock.dataprepare.extract.BasicExtractor;
import com.douglas.stock.dataprepare.extract.ExtractorInterface;

import java.io.IOException;
import java.util.List;

/**
 * Created by wgz on 15/4/10.
 */
public class F_Code_T_RawFeatures extends ProcessorUseInput {

    public F_Code_T_RawFeatures() throws IOException {
        inputClass = String.class;
    }

    private ExtractorInterface extractor = new BasicExtractor();

    public ExtractorInterface getExtractor() {
        return extractor;
    }

    public void setExtractor(ExtractorInterface extractor) {
        this.extractor = extractor;
    }

    @Override
    protected ProcessResult calc(Object object) throws InterruptedException {
        String code = (String) object;
        List<DBRecord> records = Config.getService().getByCodeOrderByDateDesc(code);

        if (records.size() < Config.getTrainWindow()) {
            return ProcessResult.SUCCESS;
        }
        RecordsTrainPredict recordsTrainPredict = new RecordsTrainPredict(records);

        // process predict records
        recordsTrainPredict.setTrain(false);
        recordsTrainPredict.setTrainBeg(0);
        recordsTrainPredict.setTrainEnd(Config.getTrainWindow());
        if (recordsTrainPredict.getRecords().size() >= Config.getTrainWindow()) {
            RawFeatures rawFeatures = extractor.extract(recordsTrainPredict);
        }

        // process train records
        recordsTrainPredict.setTrain(true);
        for (int idx = 0; idx < records.size() - Config.getWindow(); ++idx) {
            recordsTrainPredict.setLabelBeg(idx);
            recordsTrainPredict.setTrainBeg(idx + Config.getLabelWindow());
            recordsTrainPredict.setTrainEnd(idx + Config.getWindow());
            RawFeatures rawFeatures = extractor.extract(recordsTrainPredict);
        }
        return ProcessResult.SUCCESS;
    }

}
