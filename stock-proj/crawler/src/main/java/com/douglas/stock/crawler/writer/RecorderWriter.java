package com.douglas.stock.crawler.writer;

import com.douglas.stock.crawler.Record;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by wgz on 15/3/29.
 */
public class RecorderWriter {
    public DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void save(List<Record> records) {
        assert false;
    };
}
