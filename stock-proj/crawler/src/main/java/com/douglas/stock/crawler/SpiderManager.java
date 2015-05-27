package com.douglas.stock.crawler;

import cn.edu.hfut.dmic.webcollector.util.Config;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wgz on 15/3/27.
 */
public class SpiderManager {

    public static void main(String[] args) throws Exception {
        String fileName = "spiders.xml";
        if (args.length > 0) {
            fileName = args[0];
        }
        LoggerFactory.getLogger(SpiderManager.class).info("using xml [{}]", fileName);
        Config.MAX_REDIRECT = 10;
        Config.WAIT_THREAD_END_TIME = 1000 * 180;

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(fileName);
        CommonSpider spider = (CommonSpider)applicationContext.getBean("bestgoSpider");
        if (spider != null) {
            spider.start(100);
        }
    }
}
