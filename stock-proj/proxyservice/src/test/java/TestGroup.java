import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wgz on 15/4/3.
 */
public class TestGroup {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\d{1,3})\\.(\\d{1,3}).(\\d{1,3}).(\\d{1,3}):(\\d{1,3})@(HTTP|SOCK)");
        Matcher m = p.matcher("123.123.123.123:456@SOCK");
        int beg = 0;
        while (m.find()) {
            System.out.println("new");
            for (int idx=0; idx<=m.groupCount(); ++idx) {
                System.out.println(m.group(idx));
            }
        }
    }
}
