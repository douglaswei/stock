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
    private String requestUrl = "http://localhost:8080/getForUse";
    private CommonHttpRequester requester = new CommonHttpRequester();

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Proxy nextProxy() {
        return getProxy();
    }

    public Proxy getProxy() {
        return getProxy(requestUrl);
    }

    public synchronized Proxy getProxy(String url) {
        if (url == null) {
            return null;
        }
        HttpResponse response = null;
        try {
            response = requester.getResponse(url);
        } catch (Exception e) {
            return null;
        }
        if (response == null || response.getContent().length == 0) {
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
