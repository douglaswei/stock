package douglas.proxy.extract;

import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import com.douglas.stock.proxyservice.extract.BaseExtractor;
import com.douglas.stock.proxyservice.extract.PageCrawler;
import com.douglas.stock.proxyservice.EnhancedProxy;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wgz on 15/4/3.
 */
public class YDLProxyExtractor extends BaseExtractor {
    private Pattern p = Pattern.compile("(\\d{1,3}\\.\\d{1,3}.\\d{1,3}.\\d{1,3}):(\\d+)@(HTTP|SOCKS)");

    @Override
    public List extract(String url) {
        List<EnhancedProxy> proxies = new ArrayList<EnhancedProxy>();
        HttpResponse response = PageCrawler.crawl(url, null, 10000, 10000, 3);
        if (response == null) {
            return proxies;
        }
        String content = new String(response.getContent());
        synchronized (p) {
            Matcher m = p.matcher(content);
            while (m.find()) {
                String host = m.group(1);
                int port = Integer.valueOf(m.group(2));
                String sType = m.group(3);
                Proxy.Type type = sType.compareToIgnoreCase("HTTP") == 0 ? Proxy.Type.HTTP : Proxy.Type.SOCKS;
                EnhancedProxy proxy = new EnhancedProxy(type, new InetSocketAddress(host, port), 0);
                proxies.add(proxy);
            }
        }
        return proxies;
    }
}
