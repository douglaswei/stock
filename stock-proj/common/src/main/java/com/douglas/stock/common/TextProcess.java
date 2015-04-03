package com.douglas.stock.common;

/**
 * Created by wgz on 15/4/2.
 */
public class TextProcess {

    public static Float getFloat(String raw) {
        StringBuffer sb= new StringBuffer();
        for (int idx=0; idx<raw.length(); ++idx) {
            char c = raw.charAt(idx);
            if (('0' <= c) && (c <= '9') || c == '.' || c == '-' || c == '+') {
                sb.append(c);
            }
        }
        String res = sb.toString();
        if (res.length() == 0) {
            res = "0";
        }
        return Float.valueOf(res);
    }
}
