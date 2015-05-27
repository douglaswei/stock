package com.douglas.stock.common.dao;

import com.douglas.stock.common.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by wgz on 15/3/30.
 */
public class DBRecordService {
    private static final Logger logger = LoggerFactory.getLogger(DBRecord.class);
    private DBRecordDao dao;

    public DBRecordDao getDao() {
        return dao;
    }

    public void setDao(DBRecordDao dao) {
        this.dao = dao;
    }

    public void addRecord(Record record) {
        insertIfNull(record);
        String cate = record.getCategory();
        if (cate.equals("shdjt_gegu")) {
            addShdjtRecord(record);

        } else if (cate.equals("fund")) {
            addBestgoFundRecord(record);

        } else if (cate.equals("hd")) {
            addBestgoHdRecord(record);

        } else {
            logger.warn("no suitbale process for category:[{}]", record.getCategory());
        }
    }

    public List<DBRecord> getAll() {
        return dao.selectAll();
    }

    public DBRecord getOne(String code, Date date) {
        return dao.selectOne(code, date);
    }

    public List<DBRecord> getByCodeOrderByDateDesc(String code) {
        return dao.selectByCodeOrderByDateDesc(code);
    }

    public List<String> getCodes() {
        return dao.selectCodes();
    }

    public void removeOne(String code, Date date) {
        dao.deleteOne(code, date);
    }

    public void removeInvalidRecords(String code) {
        dao.deleteInvalidRecords(code);
    }

    synchronized private void insertIfNull(Record record) {
        DBRecord tmp = dao.selectOne(record.getCode(), record.getDate());
        if (tmp == null) {
            dao.insertRecord(record.getCode(), record.getDate());
        }
    }

    private void addShdjtRecord(Record record) {
        if (record.getFields().size() < 40) {
            logger.warn("lack of records[{}][{}][{}], do not process", record.getCode(), record.getCategory(), record.getDate());
            return;
        }
        List<Float> fields = record.getFields();
        int idx = 0;
        dao.updateShdjtRecord(
                record.getCode(),
                record.getDate(),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++).intValue(),
                fields.get(idx++).intValue(),
                fields.get(idx++).intValue(),
                fields.get(idx++).intValue(),
                fields.get(idx++).intValue(),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++).intValue(),
                fields.get(idx++).intValue(),
                fields.get(idx++).intValue(),
                fields.get(idx++).intValue(),
                fields.get(idx++).intValue(),
                fields.get(idx++).intValue(),
                fields.get(idx++).intValue(),
                fields.get(idx++).intValue(),
                fields.get(idx++).intValue(),
                fields.get(idx++).intValue(),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++));
    }

    private void addBestgoFundRecord(Record record) {
        if (record.getFields().size() < 15) {
            logger.warn("lack of records[{}][{}][{}], do not process", record.getCode(), record.getCategory(), record.getDate());
            return;
        }
        List<Float> fields = record.getFields();
        int idx = 0;
        dao.updateBestgoFundRecord(
                record.getCode(),
                record.getDate(),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++).intValue(),
                fields.get(idx++).intValue(),
                fields.get(idx++).intValue(),
                fields.get(idx++).intValue());

    }

    private void addBestgoHdRecord(Record record) {
        if (record.getFields().size() < 15) {
            logger.warn("lack of records[{}][{}][{}], do not process", record.getCode(), record.getCategory(), record.getDate());
            return;
        }
        List<Float> fields = record.getFields();
        int idx = 0;
        dao.updateBestgoHdRecord(
                record.getCode(),
                record.getDate(),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++),
                fields.get(idx++).intValue(),
                fields.get(idx++).intValue(),
                fields.get(idx++).intValue(),
                fields.get(idx++).intValue());
    }

}
