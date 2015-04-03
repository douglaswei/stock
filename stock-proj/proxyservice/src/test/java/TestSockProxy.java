import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import cn.edu.hfut.dmic.webcollector.net.Proxys;
import com.douglas.stock.common.CommonHttpRequester;


import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * Created by wgz on 15/4/2.
 */
public class TestSockProxy {
    public static void main(String[] args) throws Exception {
        CommonHttpRequester requester = new CommonHttpRequester();
        Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("5.8.43.98", 1433));
        Proxys proxys = new Proxys();
        proxys.add(proxy);
        requester.setProxys(proxys);
        requester.setConnectTimeOut(10000);
        requester.setReadTimeOut(10000);
        HttpResponse response = requester.getResponse("http://www.baidu.com");
        System.out.println(new String(response.getContent()));
    }
}
