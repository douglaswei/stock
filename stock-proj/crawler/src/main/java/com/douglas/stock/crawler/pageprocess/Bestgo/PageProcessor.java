package com.douglas.stock.crawler.pageprocess.Bestgo;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.douglas.stock.common.Record;
import com.douglas.stock.common.TextProcess;
import com.douglas.stock.crawler.pageprocess.BasicPageProcessor;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.xsoup.Xsoup;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wgz on 15/3/27.
 */
public class PageProcessor implements BasicPageProcessor {
    private static final Logger logger = LoggerFactory.getLogger(PageProcessor.class);
    private DateFormat dateFormat;
    private Pattern p = Pattern.compile("\\d{8}");

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public List<Record> process(Page page) {

        Matcher m = p.matcher(page.getUrl());
        if (!m.find()) {
            return null;
        }
        String dateStr = m.group();
        Date date = null;
        try {
            synchronized (dateFormat) {
                date = dateFormat.parse(dateStr);
            }
        } catch (ParseException e) {
            logger.error("exception:{}, {}", page.getUrl(), e.toString());
        }
        List<Record> records = new ArrayList<Record>();
        Elements elements = Xsoup.select(page.getHtml(), "//tbody/tr").getElements();
        for (Element element : elements) {
            Record record = getRecordFromTr(element);
            record.setDate(date);
            record.setCategory("fund");
            if (page.getUrl().indexOf("hd") >= 0) {
                record.setCategory("hd");
            }
            records.add(record);
        }
        if (logger.isDebugEnabled()) {
            for (Record record : records) {
                logger.debug("detailed records of {}:\n{}\n{}\n{}\n", page.getUrl(), record.getCode(), record.getDate(), record.getFields());
            }
        }
        return records;
    }

    private Record getRecordFromTr(Element tr) {
        Record record = new Record();
        Elements tds = Xsoup.select(tr, "//td").getElements();
        List<Float> fields = new ArrayList<Float>();
        for (int idx = 0; idx < tds.size(); ++idx) {
            switch (idx) {
                case 0:
                    record.setCode(tds.get(idx).getElementsByTag("a").text());
                    break;
                case 1:
                case 17:
                    break;
                default:
                    fields.add(TextProcess.getFloat(tds.get(idx).text()));
                    break;
            }
        }
        record.setFields(fields);
        return record;
    }
}
