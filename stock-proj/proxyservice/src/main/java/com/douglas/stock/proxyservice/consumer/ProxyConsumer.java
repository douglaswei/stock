package com.douglas.stock.proxyservice.consumer;

import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import cn.edu.hfut.dmic.webcollector.net.Proxys;
import com.douglas.stock.common.CommonHttpRequester;
import org.apache.commons.lang3.StringUtils;

import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * Created by wgz on 15/4/2.
 */
public class ProxyConsumer extends Proxys{
    private static String localUrl = "http://localhost:8080/getForUse";


    public Proxy nextProxy() {
        return getProxy();
    }

    public Proxy getProxy() {
        return getProxy(localUrl);
    }

    public Proxy getProxy(String url) {
        if (url == null) {
            return null;
        }
        CommonHttpRequester requester = new CommonHttpRequester();
        HttpResponse response = null;
        try {
            response = requester.getResponse(url);
        } catch (Exception e) {
            return null;
        }
        if (response == null) {
            return null;
        }
        String content = new String(response.getContent());
        String[] typeAddress = StringUtils.split(content, '/');
        String[] hostPort = StringUtils.split(typeAddress[1], ':');
        return new Proxy(typeAddress[0].equalsIgnoreCase("HTTP") ? Proxy.Type.HTTP : Proxy.Type.SOCKS,
                new InetSocketAddress(hostPort[0], Integer.valueOf(hostPort[1])));
    }

    public static void main(String[] args) {
        Proxy proxy = new ProxyConsumer().nextProxy();
        System.out.println(proxy);
    }
}
