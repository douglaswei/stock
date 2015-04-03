package com.douglas.stock.crawler;

import cn.edu.hfut.dmic.webcollector.util.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wgz on 15/3/27.
 */
public class SpiderManager {

    public static void main(String[] args) throws Exception {
        Config.MAX_REDIRECT = 10;
        Config.WAIT_THREAD_END_TIME = 1000 * 180;

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spiders.xml");
        CommonSpider spider = (CommonSpider)applicationContext.getBean("bestgoSpider");
        if (spider != null) {
            spider.start(100);
        }
    }
}
