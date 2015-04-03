import com.douglas.stock.common.Sleeper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wgz on 15/4/1.
 */
public class TestUrlSleeper {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spiders.xml");
        Sleeper sleeper = (Sleeper) applicationContext.getBean("sleeper");
        int ms = sleeper.getSleepTimeByUrl("http://www.shdjt.com/gpdm.asp?page=1&gpdm=600710");
        System.out.println(ms);
    }
}
