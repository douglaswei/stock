package com.douglas.stock.dataprepare.extract;

import com.douglas.stock.common.dao.DBRecord;
import com.douglas.stock.dataprepare.common.Calculation;
import com.douglas.stock.dataprepare.common.RawFeatures;
import com.douglas.stock.dataprepare.common.RecordsTrainPredict;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.douglas.stock.dataprepare.common.FeatUtil.*;

/**
 * Author:  wgz
 * Date:    15/6/12
 * Time:    上午10:16
 * Desc:
 */
public class ExtractorReadable implements ExtractorInterface {
    private final static Logger logger = LoggerFactory.getLogger(ExtractorReadable.class);
    @Override
    public RawFeatures extract(RecordsTrainPredict recordsTrainPredict) {
        RawFeatures rawFeatures = new RawFeatures();
        synchronized (recordsTrainPredict) {
            Calculation.wFuQuan(recordsTrainPredict);
            Calculation.wMACD(recordsTrainPredict);
            boolean saveFeats = true;
            if (recordsTrainPredict.isTrain()) {
                saveFeats = false;//extractLabel(recordsTrainPredict, rawFeatures);
            }
            if (saveFeats) {
                extractFeats(recordsTrainPredict, rawFeatures);
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

        // 涨幅趋势
        float ma0_1 = getAvg(records, 0, 1, "maFuquan");
        float ma0_3 = getAvg(records, 0, 3, "maFuquan");
        float ma0_5 = getAvg(records, 0, 5, "maFuquan");
        float ma0_10 = getAvg(records, 0, 10, "maFuquan");
        float ma0_20 = getAvg(records, 0, 20, "maFuquan");
        float ma0_30 = getAvg(records, 0, 30, "maFuquan");
        float ma0_60 = getAvg(records, 0, 60, "maFuquan");

        if (ma0_1 >= ma0_3 &&
                ma0_3 >= ma0_5 &&
                ma0_5 >= ma0_10 &&
                ma0_10 >= ma0_20 &&
                ma0_20 >= ma0_30 &&
                ma0_30 >= ma0_60) {
            rawFeatures.put("g_ma上升通道", 1.0f);
        }


        // hsl趋势
        float hsl0_1 = getAvg(records, 0, 1, "hsl");
        float hsl0_3 = getAvg(records, 0, 3, "hsl");
        float hsl0_5 = getAvg(records, 0, 5, "hsl");
        float hsl0_10 = getAvg(records, 0, 10, "hsl");
        float hsl0_20 = getAvg(records, 0, 20, "hsl");
        float hsl0_30 = getAvg(records, 0, 30, "hsl");
        float hsl0_60 = getAvg(records, 0, 60, "hsl");

        if (hsl0_1 >= hsl0_3 &&
                hsl0_3 >= hsl0_5 &&
                hsl0_5 >= hsl0_10 &&
                hsl0_10 >= hsl0_20 &&
                hsl0_20 >= hsl0_30 &&
                hsl0_30 >= hsl0_60) {
            rawFeatures.put("g_hsl上升通道(交易放量)", 1.0f);
        }

        // 价位位于历史高点、地点
        // 振幅
        // k线->前期涨幅、多头、多空
        rawFeatures.put("前60天长势", gradient(ma0_60, ma0_5));

        // 量比
        float lb0_1 = getAvg(records, 0, 1, "liangBi");
        float lb0_3 = getAvg(records, 0, 3, "liangBi");
        if (lb0_1 > 1 && lb0_3 > 1) {
            rawFeatures.put("g_量比放开", lb0_1);
        }

        // macd
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

        if (diff1 > 0 && dea1 > 0 && (diff1 > dea1 || diff3 > dea3) && diff5 <= dea5 && diff10 <= dea10 && dea1 > dea3) {
            rawFeatures.put("MACD金叉", 1f);
        }

        if ((diff1 < dea1 || diff3 <= dea3) && diff5 >= dea5 && diff10 >= dea10 && dea1 < dea3) {
            rawFeatures.put("MACD死叉", 1f);
        }

        if (macd1 > 0 && macd3 > 0 && macd5 > 0 && macd1 > macd3) {
            rawFeatures.put("MACD多头", 1f);
        }

        if (macd1 < 0 && macd3 < 0 && macd5 < 0 && macd10 < 0 && macd1 < macd3) {
            rawFeatures.put("MACD多空", 1f);
        }

    }

}
