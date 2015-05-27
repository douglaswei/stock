package com.douglas.stock.dataprepare.common;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by wgz on 15/4/10.
 */
public class RawFeatures extends HashMap<String, String> {
    public final static String labelName = "label";
    public final static String codeName = "code";
    public final static String dateName = "date";
    public final static DecimalFormat decimalFormat = new DecimalFormat("#.####");
    public final static DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    public String toString() {
        StringBuffer sb = new StringBuffer();

        String labelRes = get(labelName);
        labelRes = labelRes == null ? "" : labelRes;
        sb.append(String.format("%s:%s\t%s:%s\t%s:%s", labelName, labelRes, codeName, get(codeName), dateName, get(dateName)));

        for (String key : keySet()) {
            if (key.equals(labelName) || key.equals(codeName) || key.equals(dateName)) {
                continue;
            }
            String value = get(key);
            sb.append(String.format("\t%s:%s", key.trim(), value));
        }
        return sb.toString();
    }

    public void put(String k, float v) {
        put(k, decimalFormat.format(v));
    }

    public void putLabel(float v) {
        put(labelName, v);
    }

    public void putDate(Date date) {
        synchronized (dateFormat) {
            put(dateName, dateFormat.format(date));
        }
    }

    public void putCode(String code) {
        put(codeName, code);
    }
}
