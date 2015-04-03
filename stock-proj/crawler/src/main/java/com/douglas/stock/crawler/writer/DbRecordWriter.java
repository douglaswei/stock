package com.douglas.stock.crawler.writer;

import com.douglas.stock.crawler.Record;
import com.douglas.stock.crawler.dao.DBRecordService;

import java.util.List;

/**
 * Created by wgz on 15/3/29.
 */
public class DbRecordWriter extends RecorderWriter {
    private DBRecordService service;

    public DBRecordService getService() {
        return service;
    }

    public void setService(DBRecordService service) {
        this.service = service;
    }

    public void save(List<Record> records) {
        for (Record record : records) {
            service.addRecord(record);
        }
    };

}
