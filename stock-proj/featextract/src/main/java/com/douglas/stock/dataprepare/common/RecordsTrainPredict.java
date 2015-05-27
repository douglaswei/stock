package com.douglas.stock.dataprepare.common;

import com.douglas.stock.common.Config;
import com.douglas.stock.common.dao.DBRecord;

import java.util.List;

/**
 * Created by wgz on 15/4/10.
 */
public class RecordsTrainPredict {
    final private List<DBRecord> records;
    private boolean isTrain = false;
    private int labelBeg;
    private int trainBeg;
    private int trainEnd;

    public RecordsTrainPredict(final List<DBRecord> records) {
        this.records = records;
    }

    public List<DBRecord> getRecords() {
        return records;
    }

    public boolean isTrain() {
        return isTrain;
    }

    public void setTrain(boolean isTrain) {
        this.isTrain = isTrain;
    }

    public int getLabelBeg() {
        return labelBeg;
    }

    public void setLabelBeg(int labelBeg) {
        this.labelBeg = labelBeg;
    }

    public int getTrainBeg() {
        return trainBeg;
    }

    public void setTrainBeg(int trainBeg) {
        this.trainBeg = trainBeg;
    }

    public int getTrainEnd() {
        return trainEnd;
    }

    public void setTrainEnd(int trainEnd) {
        this.trainEnd = trainEnd;
    }
}
