package com.douglas.stock.common;

import cn.edu.hfut.dmic.webcollector.net.Proxys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;

/**
 * Created by wgz on 15/3/29.
 */
public class ProxysFromFile extends Proxys {
    public final static Logger logger = LoggerFactory.getLogger(ProxysFromFile.class);
    public ProxysFromFile(String filename) {
        super();
        try {
            URL url = getClass().getClassLoader().getResource(filename);
            this.addAllFromFile(new File(url.getPath()));
        } catch (Exception e) {
            logger.error("fail to load proxies, exception:", e);
        }
    }
}
