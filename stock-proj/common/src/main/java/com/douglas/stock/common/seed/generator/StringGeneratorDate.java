package com.douglas.stock.common.seed.generator;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by wgz on 15/4/1.
 */
public class StringGeneratorDate implements StringGenerator {
    private Date date = new Date();
    private int backwardSpan = 1;
    private DateFormat dateFormat;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getBackwardSpan() {
        return backwardSpan;
    }

    public void setBackwardSpan(int backwardSpan) {
        this.backwardSpan = backwardSpan;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public List<String> getStrings() {
        List<String> strs = new ArrayList<String>();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        for (int idx = 0; idx < backwardSpan; ++idx) {
            calendar.add(Calendar.DATE, -1);
            Date ndate = calendar.getTime();
            strs.add(dateFormat.format(ndate));
        }
        return strs;
    }
}
