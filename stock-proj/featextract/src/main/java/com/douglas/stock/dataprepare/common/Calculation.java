package com.douglas.stock.dataprepare.common;

import com.douglas.stock.common.dao.DBRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by wgz on 15/4/10.
 */
public class Calculation {
    public final static Logger logger = LoggerFactory.getLogger(Calculation.class);
    public static void F_prepare(List<DBRecord> records) {
    }

    public static void wFuQuan(RecordsTrainPredict recordsTrainPredict) {
        if (recordsTrainPredict == null) {
            return;
        }
        float ratio = (float) 1.0;
        List<DBRecord> records = recordsTrainPredict.getRecords();
        if (records == null) {
            return;
        }
        int beg = recordsTrainPredict.getTrainBeg();
        if (recordsTrainPredict.isTrain()) {
            beg = recordsTrainPredict.getLabelBeg();
        }
        for (int idx = beg; idx < records.size(); ++idx) {
            DBRecord cur = records.get(idx);
            int idprev = idx+1;
            float fuquanMa = ((float)Math.round(cur.getMa() * ratio * 100)) / 100;
            cur.setMaFuquan(fuquanMa);

            if (idprev >= records.size()) {
                break;
            }

            DBRecord prev = records.get(idprev);
            float curRatio = cur.getMa() * 100 / (prev.getMa() * (100 + cur.getMaGradient()));
            curRatio = (float)Math.round(curRatio * 100) / 100;
            ratio *= curRatio;
            if (curRatio != 1.0) {
                logger.debug("cur ratio [{}], new ratio [{}]", curRatio, ratio);
            }
        }
    }

    public static void wMACD(RecordsTrainPredict recordsTrainPredict) {
        if (recordsTrainPredict == null) {
            return;
        }
        List<DBRecord> records = recordsTrainPredict.getRecords();
        if (records == null) {
            return;
        }
        float[] maFuquan = getElesByName(records, 0, records.size(), "maFuquan");
        DBRecord last = records.get(records.size()-1);
        last.setEma12(maFuquan[records.size() - 1]);
        last.setEma26(maFuquan[records.size() - 1]);
        for (int idx=records.size()-2; idx >= recordsTrainPredict.getTrainBeg(); --idx) {
            DBRecord cur = records.get(idx);
            cur.setEma12(maFuquan[idx] * 2 / 13 + records.get(idx + 1).getEma12() * 11 / 13);
            cur.setEma26(maFuquan[idx] * 2 / 27 + records.get(idx + 1).getEma12() * 25 / 27);
            cur.setDiff(cur.getEma12() - cur.getEma26());
            float prevDea = 0;
            if (idx + 1 < records.size()) {
                prevDea = records.get(idx+1).getDea();
            }
            cur.setDea((float) (prevDea * 0.8 + cur.getDiff() * 0.2));
            cur.setMacd(2*(cur.getDiff() - cur.getDea()));
        }
    }

    private static float[] getElesByName(List<DBRecord> records, int beg, int end, String name) {
        Field field = getFieldByName(DBRecord.class, name);
        float[] res = new float[end - beg];
        try {
            for (int idx = beg; idx < end; ++idx) {
                res[idx-beg] = field.getFloat(records.get(idx));
            }
        } catch (IllegalAccessException e) {
            logger.warn(e.toString());
            return null;
        }
        return res;
    }

    public static float sMean(float[] args, int beg, int len) {
        int end = Math.min(beg + len, args.length);
        float sum = 0;
        for (int idx = beg; idx < end; ++idx) {
            sum += args[idx];
            if (idx == beg) {
                sum += args[idx];
            }
        }
        return sum / (len + 1);
    }

    public static Field getFieldByName(Class type, String name) {
        Field field = null;
        try {
            field = type.getDeclaredField(name);
            field.setAccessible(true);
        } catch (NoSuchFieldException e) {
            logger.warn(e.toString());
            return null;
        }
        return field;
    }
}
