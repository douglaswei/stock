package com.douglas.stock.dataprepare.extract;

import com.douglas.stock.common.Config;
import com.douglas.stock.common.dao.DBRecord;
import com.douglas.stock.dataprepare.common.Calculation;
import com.douglas.stock.dataprepare.common.RawFeatures;
import com.douglas.stock.dataprepare.common.RecordsTrainPredict;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by wgz on 15/4/10.
 */
public class BasicExtractor implements ExtractorInterface {
    private static BufferedWriter bufferedWriter = null;
    private final static Logger logger = LoggerFactory.getLogger("FeatExtractor");
    @Override
    public RawFeatures extract(RecordsTrainPredict recordsTrainPredict) {
        RawFeatures rawFeatures = new RawFeatures();
        synchronized (recordsTrainPredict) {
            Calculation.wFuQuan(recordsTrainPredict);
            Calculation.wMACD(recordsTrainPredict);
            extractFeats(recordsTrainPredict, rawFeatures);
            boolean saveFeats = true;
            if (recordsTrainPredict.isTrain()) {
                saveFeats = extractLabel(recordsTrainPredict, rawFeatures);
            }
            if (saveFeats) {
                saveFeatures(rawFeatures);
            }
            return rawFeatures;
        }
    }

    private void extractFeats(RecordsTrainPredict recordsTrainPredict, RawFeatures rawFeatures) {
        if (recordsTrainPredict == null || recordsTrainPredict.getRecords().size() == 0 || rawFeatures == null) {
            return;
        }
        int trainBeg = recordsTrainPredict.getTrainBeg();
        int trainEnd = recordsTrainPredict.getTrainEnd();
        List<DBRecord> records = recordsTrainPredict.getRecords();
        DBRecord begRecord = records.get(trainBeg);

        rawFeatures.putCode(begRecord.getCode());
        rawFeatures.putDate(begRecord.getDate());

        putOriginFeat(begRecord, rawFeatures, "ma");
        putOriginFeat(begRecord, rawFeatures, "maGradient");
        putOriginFeat(begRecord, rawFeatures, "hsl");
        putOriginFeat(begRecord, rawFeatures, "ddx");
        putOriginFeat(begRecord, rawFeatures, "bbd");
        putOriginFeat(begRecord, rawFeatures, "liuTongShiZhi");
        putOriginFeat(begRecord, rawFeatures, "jinLiuru");
        putOriginFeat(begRecord, rawFeatures, "cashStrength1");
        putOriginFeat(begRecord, rawFeatures, "cashStrength3");
        putOriginFeat(begRecord, rawFeatures, "cashStrength5");
        putOriginFeat(begRecord, rawFeatures, "cashStrength10");
        putOriginFeat(begRecord, rawFeatures, "cashRed3");
        putOriginFeat(begRecord, rawFeatures, "cashRed5");
        putOriginFeat(begRecord, rawFeatures, "cashRed10");
        putOriginFeat(begRecord, rawFeatures, "cashRed20");
        putOriginFeat(begRecord, rawFeatures, "hdJingLiang");
        putOriginFeat(begRecord, rawFeatures, "hdCashStrength1");
        putOriginFeat(begRecord, rawFeatures, "hdCashStrength3");
        putOriginFeat(begRecord, rawFeatures, "hdCashStrength5");
        putOriginFeat(begRecord, rawFeatures, "hdCashStrength10");
        putOriginFeat(begRecord, rawFeatures, "hdCashRed3");
        putOriginFeat(begRecord, rawFeatures, "hdCashRed5");
        putOriginFeat(begRecord, rawFeatures, "hdCashRed10");
        putOriginFeat(begRecord, rawFeatures, "hdCashRed20");
        putOriginFeat(begRecord, rawFeatures, "diff");
        putOriginFeat(begRecord, rawFeatures, "dea");
        putOriginFeat(begRecord, rawFeatures, "macd");

        putOriginFeat(begRecord, rawFeatures, "diffActionXBig");
        putOriginFeat(begRecord, rawFeatures, "diffActionBig");
        putOriginFeat(begRecord, rawFeatures, "diffActionMid");
        putOriginFeat(begRecord, rawFeatures, "diffActionPercentSmall");
        putOriginFeat(begRecord, rawFeatures, "activity");
        putOriginFeat(begRecord, rawFeatures, "volRatio");
        putOriginFeat(begRecord, rawFeatures, "ddx5");
        putOriginFeat(begRecord, rawFeatures, "ddy5");
        putOriginFeat(begRecord, rawFeatures, "ddx60");
        putOriginFeat(begRecord, rawFeatures, "ddy60");
        putOriginFeat(begRecord, rawFeatures, "volIn");
        putOriginFeat(begRecord, rawFeatures, "volOut");
        putOriginFeat(begRecord, rawFeatures, "avgVolIn");
        putOriginFeat(begRecord, rawFeatures, "avgVolOut");
        putOriginFeat(begRecord, rawFeatures, "cumulateSmall");
        putOriginFeat(begRecord, rawFeatures, "cumulateNet");
        putOriginFeat(begRecord, rawFeatures, "inPercentXLarge");
        putOriginFeat(begRecord, rawFeatures, "outPercentXLarge");
        putOriginFeat(begRecord, rawFeatures, "inPercentLarge");
        putOriginFeat(begRecord, rawFeatures, "outPercentLarge");
        putOriginFeat(begRecord, rawFeatures, "inPercentMid");
        putOriginFeat(begRecord, rawFeatures, "outPercentMid");
        putOriginFeat(begRecord, rawFeatures, "inPercentSmall");
        putOriginFeat(begRecord, rawFeatures, "outPercentSmall");
        putOriginFeat(begRecord, rawFeatures, "liangBi");
        putOriginFeat(begRecord, rawFeatures, "peRatio");
        putOriginFeat(begRecord, rawFeatures, "pePs");

        rawFeatures.put("diff_minus_eda", begRecord.getDiff() - begRecord.getDea());

        float ma1 = getAvg(records, 0, 1, "maFuquan");
        float ma3 = getAvg(records, 0, 3, "maFuquan");
        float ma5 = getAvg(records, 0, 5, "maFuquan");
        float ma10 = getAvg(records, 0, 10, "maFuquan");
        float ma20 = getAvg(records, 0, 20, "maFuquan");
        float ma30 = getAvg(records, 0, 30, "maFuquan");
        float ma60 = getAvg(records, 0, 60, "maFuquan");

        float hsl1 = getAvg(records, 0, 1, "hsl");
        float hsl3 = getAvg(records, 0, 3, "hsl");
        float hsl5 = getAvg(records, 0, 5, "hsl");
        float hsl10 = getAvg(records, 0, 10, "hsl");
        float hsl20 = getAvg(records, 0, 20, "hsl");
        float hsl30 = getAvg(records, 0, 30, "hsl");
        float hsl60 = getAvg(records, 0, 60, "hsl");

        float diff1 = getAvg(records, 0, 1, "diff");
        float diff3 = getAvg(records, 0, 3, "diff");
        float diff5 = getAvg(records, 0, 5, "diff");
        float diff10 = getAvg(records, 0, 10, "diff");

        float dea1 = getAvg(records, 0, 1, "dea");
        float dea3 = getAvg(records, 0, 3, "dea");
        float dea5 = getAvg(records, 0, 5, "dea");
        float dea10 = getAvg(records, 0, 10, "dea");

        float macd1 = getAvg(records, 0, 1, "macd");
        float macd3 = getAvg(records, 0, 3, "macd");
        float macd5 = getAvg(records, 0, 5, "macd");
        float macd10 = getAvg(records, 0, 10, "macd");


        float jinLiuru1 = getAvg(records, 0, 1, "jinLiuru");
        float jinLiuru3 = getAvg(records, 0, 3, "jinLiuru");
        float jinLiuru5 = getAvg(records, 0, 5, "jinLiuru");

        float hdJingLiang1 = getAvg(records, 0, 1, "hdJingLiang");
        float hdJingLiang3 = getAvg(records, 0, 3, "hdJingLiang");
        float hdJingLiang5 = getAvg(records, 0, 5, "hdJingLiang");


        rawFeatures.put("ma_1_3_grandient", gradient(ma1, ma3));
        rawFeatures.put("ma_1_5_grandient", gradient(ma1, ma5));
        rawFeatures.put("ma_1_10_grandient", gradient(ma1, ma10));
        rawFeatures.put("ma_1_20_grandient", gradient(ma1, ma20));
        rawFeatures.put("ma_1_30_grandient", gradient(ma1, ma30));
        rawFeatures.put("ma_1_60_grandient", gradient(ma1, ma60));
        rawFeatures.put("ma_3_5_grandient", gradient(ma3, ma5));
        rawFeatures.put("ma_5_10_grandient", gradient(ma5, ma10));
        rawFeatures.put("ma_10_20_grandient", gradient(ma10, ma20));
        rawFeatures.put("ma_20_30_grandient", gradient(ma20, ma30));
        rawFeatures.put("ma_30_60_grandient", gradient(ma30, ma60));

        rawFeatures.put("hsl_1_3_grandient", gradient(hsl1, hsl3));
        rawFeatures.put("hsl_1_5_grandient", gradient(hsl1, hsl5));
        rawFeatures.put("hsl_1_10_grandient", gradient(hsl1, hsl10));
        rawFeatures.put("hsl_1_20_grandient", gradient(hsl1, hsl20));
        rawFeatures.put("hsl_1_30_grandient", gradient(hsl1, hsl30));
        rawFeatures.put("hsl_1_60_grandient", gradient(hsl1, hsl60));
        rawFeatures.put("hsl_3_5_grandient", gradient(hsl3, hsl5));
        rawFeatures.put("hsl_5_10_grandient", gradient(hsl5, hsl10));
        rawFeatures.put("hsl_10_20_grandient", gradient(hsl10, hsl20));
        rawFeatures.put("hsl_20_30_grandient", gradient(hsl20, hsl30));
        rawFeatures.put("hsl_30_60_grandient", gradient(hsl30, hsl60));

        rawFeatures.put("diff_1_3_grandient", gradient(diff1, diff3));
        rawFeatures.put("diff_1_5_grandient", gradient(diff1, diff5));
        rawFeatures.put("diff_1_10_grandient", gradient(diff1, diff10));
        rawFeatures.put("diff_3_5_grandient", gradient(diff3, diff5));
        rawFeatures.put("diff_5_10_grandient", gradient(diff5, diff10));

        rawFeatures.put("eda_1_3_grandient", gradient(dea1, dea3));
        rawFeatures.put("eda_1_5_grandient", gradient(dea1, dea5));
        rawFeatures.put("eda_1_10_grandient", gradient(dea1, dea10));
        rawFeatures.put("eda_3_5_grandient", gradient(dea3, dea5));
        rawFeatures.put("eda_5_10_grandient", gradient(dea5, dea10));

        rawFeatures.put("macd_1_3_grandient", gradient(macd1, macd3));
        rawFeatures.put("macd_1_5_grandient", gradient(macd1, macd5));
        rawFeatures.put("macd_1_10_grandient", gradient(macd1, macd10));
        rawFeatures.put("macd_3_5_grandient", gradient(macd1, macd5));
        rawFeatures.put("macd_5_10_grandient", gradient(macd1, macd10));

        rawFeatures.put("jinLiuru_1_3_grandient", gradient(jinLiuru1, jinLiuru3));
        rawFeatures.put("jinLiuru_1_5_grandient", gradient(jinLiuru1, jinLiuru5));
        rawFeatures.put("jinLiuru_3_5_grandient", gradient(jinLiuru3, jinLiuru5));

        rawFeatures.put("hdJingLiang_1_3_grandient", gradient(hdJingLiang1, hdJingLiang3));
        rawFeatures.put("hdJingLiang_1_5_grandient", gradient(hdJingLiang1, hdJingLiang5));
        rawFeatures.put("hdJingLiang_3_5_grandient", gradient(hdJingLiang3, hdJingLiang5));

        // 强特征
        rawFeatures.put("pm_1_3_ma", ma1 > ma3 ? 1: 0);
        rawFeatures.put("pm_3_5_ma", ma3 > ma5 ? 1: 0);
        rawFeatures.put("pm_1_3_hsl", hsl1 > hsl3 ? 1: 0);
        rawFeatures.put("pm_3_5_hsl", hsl3 > hsl5 ? 1: 0);
        rawFeatures.put("pm_1_3_diff", diff1 > diff3 ? 1: 0);
        rawFeatures.put("pm_3_5_diff", diff3 > diff5 ? 1: 0);
        rawFeatures.put("pm_1_3_dea", dea1 > dea3 ? 1: 0);
        rawFeatures.put("pm_3_5_dea", dea3 > dea5 ? 1: 0);
        rawFeatures.put("pm_1_3_macd", macd1 > macd3 ? 1: 0);
        rawFeatures.put("pm_3_5_macd", macd3 > macd5 ? 1: 0);
        rawFeatures.put("pm_1_3_jinLiuRu", jinLiuru1 > jinLiuru3 ? 1: 0);
        rawFeatures.put("pm_3_5_jinLiuRu", jinLiuru3 > jinLiuru5 ? 1: 0);
        rawFeatures.put("pm_1_3_hdJingLiang", hdJingLiang1 > hdJingLiang3 ? 1: 0);
        rawFeatures.put("pm_3_5_hdJingLiang", hdJingLiang3 > hdJingLiang5 ? 1: 0);

    }

    private boolean extractLabel(RecordsTrainPredict recordsTrainPredict, RawFeatures rawFeatures) {
        float label = (gradient(recordsTrainPredict.getRecords().get(recordsTrainPredict.getTrainBeg()).getMaFuquan(),
                getAvg(recordsTrainPredict.getRecords(), recordsTrainPredict.getLabelBeg(), recordsTrainPredict.getTrainBeg() - recordsTrainPredict.getLabelBeg(), "maFuquan"))
                - 1) * 100;
        rawFeatures.putLabel(label);
        if (label >= Config.getLabelThresholdLower() && label <= Config.getLabelThresholdUpper()) {
            return false;
        }
        if (label > Config.getExceptionUppder() || label < Config.getExceptionLower()) {
            logger.warn("ignore ignormal data, [{}]", rawFeatures.toString());
            return false;
        }
        return true;
    }

    private float getValueByName(DBRecord record, String name) {
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

    private void putOriginFeat(DBRecord record, RawFeatures rawFeatures, String name) {
        if (record == null || rawFeatures == null) {
            return;
        }
        rawFeatures.put(name, getValueByName(record, name));
    }

    private float getAvg(List<DBRecord> records, int beg, int len, String name) {
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

    private float gradient(float denominator, float numerator) {
        if (denominator == 0) {
            return 0;
        }
        return numerator / denominator;
    }


    private static synchronized void saveFeatures(RawFeatures rawFeatures) {
        if (bufferedWriter == null) {
            bufferedWriter = Config.getBufferedWriter();
        }
        try {
            bufferedWriter.write(rawFeatures.toString() + '\n');
        } catch (IOException e) {
            logger.warn("exception", e);
        }
    }
}
