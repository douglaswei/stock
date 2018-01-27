package com.douglas.stock.proxyservice.controller;

/**
 * Created by wgz on 15/4/2.
 * <p>
 * Created by wgz on 15/3/27.
 */
/**
 * Created by wgz on 15/3/27.
 */

import com.douglas.stock.proxyservice.bean.EnhancedProxy;
import com.douglas.stock.proxyservice.extract.ProxyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@RestController
public class ProxyProviderHandler {

    @Autowired
    private ProxyGenerator proxyGenerator;

    private static Random random = new Random();

    @RequestMapping("/getForUse")
    String getForUse() {
        EnhancedProxy proxy = proxyGenerator.getForUse();
        if (proxy == null) {
            return "";
        }
        return proxy.type().toString() + proxy.address().toString();
    }

    @RequestMapping("/size")
    Integer getSize() {
        return proxyGenerator.getProxyRes().size();
    }

    @RequestMapping("/ping")
    String ping() {
        return "alive";
    }


}
