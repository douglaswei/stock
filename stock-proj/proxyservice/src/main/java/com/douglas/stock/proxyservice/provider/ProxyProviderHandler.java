package com.douglas.stock.proxyservice.provider;

/**
 * Created by wgz on 15/4/2.
 */
/**
 * Created by wgz on 15/3/27.
 */

import com.douglas.stock.proxyservice.EnhancedProxy;
import com.douglas.stock.proxyservice.extract.ProxyGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Random;


@RestController
@EnableAutoConfiguration
public class ProxyProviderHandler {
    private static ProxyGenerator proxyGenerator = ProxyGenerator.getInstance();
    private long refreshInterval = 12 * 60 * 60 * 1000;
    private static Random random = new Random();

    class Producer extends Thread {
        public void run() {
            while (true) {
                try {
                    proxyGenerator.run();
                    Thread.sleep(refreshInterval);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }



    public ProxyProviderHandler() {
        Producer producer = new Producer();
        producer.start();
    }


    @RequestMapping("/getForUse")
    String getForUse() {
        EnhancedProxy proxy = proxyGenerator.getForUse();
        if (proxy == null) {
            return "";
        }
        return proxy.type().toString() + proxy.address().toString() ;
    }

    @RequestMapping("/ping")
    String ping() {
        return "alive";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ProxyProviderHandler.class, args);
    }

}
