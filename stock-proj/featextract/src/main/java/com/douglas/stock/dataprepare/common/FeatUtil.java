package com.douglas.stock.dataprepare.common;

import com.douglas.stock.common.Config;
import com.douglas.stock.common.dao.DBRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Author:  wgz
 * Date:    15/6/15
 * Time:    上午10:59
 * Desc:
 */
public class FeatUtil {
    private static Logger logger = LoggerFactory.getLogger(FeatUtil.class);

    public static boolean extractLabel(RecordsTrainPredict recordsTrainPredict, RawFeatures rawFeatures) {
        float label = (gradient(recordsTrainPredict.getRecords().get(recordsTrainPredict.getTrainBeg()).getMaFuquan(),
                getAvg(recordsTrainPredict.getRecords(), recordsTrainPredict.getLabelBeg(), recordsTrainPredict.getTrainBeg() - recordsTrainPredict.getLabelBeg(), "maFuquan"))
        ) * 100;
        rawFeatures.putLabel(label);
        if (label >= Config.getLabelThresholdLower() && label <= Config.getLabelThresholdUpper()) {
            return false;
        }
        if (label > Config.getExceptionUpper() || label < Config.getExceptionLower()) {
            logger.warn("ignore ignormal data, [{}]", rawFeatures.toString());
            return false;
        }
        return true;
    }

    public static float getValueByName(DBRecord record, String name) {
        Field field = Calculation.getFieldByName(DBRecord.class, name);
        if (field == null) {
            return 0;
        }
        try {
            return field.getFloat(record);
        } catch (IllegalAccessException e) {
            return 0;
        }
    }

    public static void putOriginFeat(DBRecord record, RawFeatures rawFeatures, String name) {
        if (record == null || rawFeatures == null) {
            return;
        }
        rawFeatures.put(name, getValueByName(record, name));
    }

    public static void putOriginFeatPM(DBRecord record, RawFeatures rawFeatures, String name) {
        if (record == null || rawFeatures == null) {
            return;
        }
        rawFeatures.put("pm_" + name, getValueByName(record, name) > 0 ? 1 : 0);
    }

    public static void putOriginFeatGradient(DBRecord record, RawFeatures rawFeatures, String name1, String name2) {
        if (record == null || rawFeatures == null) {
            return;
        }
        float grad = gradient(getValueByName(record, name1), getValueByName(record, name2));
        rawFeatures.put("diff_pm_" + name1 + "_" + name2, grad);
        rawFeatures.put("diff_pm_gradient_" + name1 + "_" + name2, grad > 0 ? 1 : 0);
    }

    public static float getAvg(List<DBRecord> records, int beg, int len, String name) {
        float sum = 0;
        int count = 0;
        if (records == null || name == null) {
            return sum;
        }
        for (int idx = beg; idx < beg+len; ++idx) {
            if (idx >= records.size()) {
                break;
            }
            ++count;
            sum += getValueByName(records.get(idx), name);
        }
        if (count == 0) {
            return 0;
        }
        return sum / count;
    }

    public static float gradient(float denominator, float numerator) {
        if (denominator == 0) {
            denominator = 0.1f;
        }
        return (numerator - denominator) / denominator;
    }


    public static synchronized void saveFeatures(RawFeatures rawFeatures) {
        BufferedWriter bufferedWriter = Config.getBufferedWriter();
        try {
            bufferedWriter.write(rawFeatures.toString() + '\n');
        } catch (IOException e) {
            logger.warn("exception", e);
        }
    }
}
