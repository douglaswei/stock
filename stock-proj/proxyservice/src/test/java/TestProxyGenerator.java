import com.douglas.stock.proxyservice.extract.ProxyGenerator;

/**
 * Created by wgz on 15/4/3.
 */
public class TestProxyGenerator {
    public static void main(String[] args) throws InterruptedException {
        ProxyGenerator generator = ProxyGenerator.getInstance();
        generator.run();
    }
}
