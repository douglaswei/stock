package douglas.stock.spider.dao;

import douglas.stock.spider.Record;
import org.apache.ibatis.annotations.Param;
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
        List<String> fields = record.getFields();
        int idx = 0;
        dao.updateShdjtRecord(
                record.getCode(),
                record.getDate(),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)));
    }

    private void addBestgoFundRecord(Record record) {
        if (record.getFields().size() < 15) {
            logger.warn("lack of records[{}][{}][{}], do not process", record.getCode(), record.getCategory(), record.getDate());
            return;
        }
        List<String> fields = record.getFields();
        int idx = 0;
        dao.updateBestgoFundRecord(
                record.getCode(),
                record.getDate(),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)).intValue());

    }

    private void addBestgoHdRecord(Record record) {
        if (record.getFields().size() < 15) {
            logger.warn("lack of records[{}][{}][{}], do not process", record.getCode(), record.getCategory(), record.getDate());
            return;
        }
        List<String> fields = record.getFields();
        int idx = 0;
        dao.updateBestgoHdRecord(
                record.getCode(),
                record.getDate(),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)).intValue(),
                Float.valueOf(fields.get(idx++)).intValue());
    }

}
