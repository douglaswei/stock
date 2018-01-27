import com.douglas.stock.proxyservice.ProxyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wgz on 15/4/3.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ProxyApplication.class)
public class TestGroup {

    @Test
    public void testMatch() {
        Pattern p = Pattern.compile("(\\d{1,3})\\.(\\d{1,3}).(\\d{1,3}).(\\d{1,3}):(\\d{1,3})@(HTTP|SOCK)");
        Matcher m = p.matcher("123.123.123.123:456@SOCK");
        int beg = 0;
        while (m.find()) {
            System.out.println("new");
            for (int idx = 0; idx <= m.groupCount(); ++idx) {
                System.out.println(m.group(idx));
            }
        }
    }
}
