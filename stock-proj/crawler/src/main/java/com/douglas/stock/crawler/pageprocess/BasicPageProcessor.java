package com.douglas.stock.crawler.pageprocess;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.douglas.stock.crawler.Record;

import java.util.List;

/**
 * Created by wgz on 15/3/27.
 */
public interface BasicPageProcessor {
    public List<Record> process(Page page);
}
