package douglas.stock.spider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;
import java.util.Set;

/**
 * Created by wgz on 15/3/27.
 */
public class SpiderManager {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spiders.xml");
        CommonSpider spider = (CommonSpider)applicationContext.getBean("bestgoSpider");
        if (spider != null) {
            spider.start(2^10);
        }
    }
}
