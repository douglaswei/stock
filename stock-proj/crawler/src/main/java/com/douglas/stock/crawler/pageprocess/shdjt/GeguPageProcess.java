package com.douglas.stock.crawler.pageprocess.shdjt;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.douglas.stock.crawler.Record;
import com.douglas.stock.common.TextProcess;
import com.douglas.stock.crawler.pageprocess.BasicPageProcessor;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.xsoup.Xsoup;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wgz on 15/3/31.
 */
public class GeguPageProcess implements BasicPageProcessor {
    private final static Logger logger = LoggerFactory.getLogger(GeguPageProcess.class);
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public List<Record> process(Page page) {
        return processHtml(page.getHtml());
    }

    public List<Record> processHtml(String html) {
        Elements eles = Xsoup.select(html, "//tbody/tr").getElements();
        ArrayList<Record> records = new ArrayList<>();
        for (Element ele : eles) {
            Record record = getRecordFromTr(ele);
            if (record != null) {
                records.add(record);
            }
        }
        return records;
    }

    public Record getRecordFromTr(Element tr) {
        Elements tds = tr.getElementsByTag("td");
        if (tds.size() != 50 || !StringUtils.isNumeric(tds.get(2).text())) {
            return null;
        }

        Record record = new Record();
        record.setFields(new ArrayList<Float>());
        record.setCategory("shdjt_gegu");
        for (int idx = 0; idx < tds.size(); ++idx) {
            Element td = tds.get(idx);
            switch (idx) {
                case 1:
                case 3:
                case 49:
                    break;
                case 0:
                    if (dateFormat != null) {
                        synchronized (dateFormat) {
                            try {
                                Date date = dateFormat.parse(td.text());
                                record.setDate(date);
                            } catch (ParseException e) {
                                logger.error("date error: ", e);
                                return null;
                            }
                        }
                    }
                    break;
                case 2:
                    record.setCode(new String(td.text()));
                    break;
                default:
                    Float v = TextProcess.getFloat(td.text());
                    record.getFields().add(v);
                    break;
            }
        }
        if (Float.valueOf(record.getFields().get(0)) == 0) {
            return null;
        }
        return record;
    }
}
