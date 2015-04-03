package com.douglas.stock.common;

import cn.edu.hfut.dmic.webcollector.net.HttpRequester;
import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import cn.edu.hfut.dmic.webcollector.net.Proxys;
import cn.edu.hfut.dmic.webcollector.util.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;

/**
 * Created by wgz on 15/4/1.
 */
public class CommonHttpRequester implements HttpRequester {

    public static final Logger LOG = LoggerFactory.getLogger(CommonHttpRequester.class);
    protected Proxys proxys = null;
    protected List<String> userAgents;// = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:27.0) Gecko/20100101 Firefox/27.0";
    protected String cookie = null;
    private Random random = new Random();
    private int connectTimeOut = 5000;
    private int readTimeOut = 20000;
    private int contentLengthLimit = 0;

    public void configConnection(HttpURLConnection con) {

    }

    @Override
    public HttpResponse getResponse(String url) throws Exception {
        HttpResponse response = new HttpResponse(url);
        HttpURLConnection con = null;
        URL _URL = new URL(url);
        int code = -1;
        int maxRedirect = Math.max(0, Config.MAX_REDIRECT);
        for (int redirect = 0; redirect <= maxRedirect; redirect++) {
            if (proxys == null) {
                con = (HttpURLConnection) _URL.openConnection();
            } else {
                Proxy proxy = proxys.nextProxy();
                if (proxy == null) {
                    con = (HttpURLConnection) _URL.openConnection();
                } else {
                    con = (HttpURLConnection) _URL.openConnection(proxy);
                }
            }
            //con.setInstanceFollowRedirects(false);
            if (userAgents != null) {
                int idx = random.nextInt(userAgents.size());
                con.setRequestProperty("User-Agent", userAgents.get(idx));
            }
            if (cookie != null) {
                con.setRequestProperty("Cookie", cookie);
            }
            con.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            con.setInstanceFollowRedirects(false);
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setConnectTimeout(connectTimeOut);
            con.setReadTimeout(readTimeOut);

            configConnection(con);
            code = con.getResponseCode();
            /*只记录第一次返回的code*/
            if (redirect == 0) {
                response.setCode(code);
            }

            boolean needBreak = false;
            switch (code) {
                case HttpURLConnection.HTTP_MOVED_PERM:
                case HttpURLConnection.HTTP_MOVED_TEMP:
                    response.setRedirect(true);
                    if (redirect == Config.MAX_REDIRECT) {
                        throw new Exception("redirect to much time");
                    }
                    String location = con.getHeaderField("Location");
                    if (location == null) {
                        throw new Exception("redirect with no location");
                    }
                    String originUrl = _URL.toString();
                    _URL = new URL(_URL, location);
                    response.setRealUrl(_URL.toString());
                    LOG.info("redirect from " + originUrl + " to " + _URL.toString());
                    continue;
                default:
                    needBreak = true;
                    break;
            }
            if (needBreak) {
                break;
            }

        }

        InputStream is;

        is = con.getInputStream();
        String contentEncoding = con.getContentEncoding();
        if (contentEncoding != null && contentEncoding.equals("gzip")) {
            is = new GZIPInputStream(is);
        }

        byte[] buf = new byte[2048];
        int read;
        int sum = 0;
        int maxsize = Config.MAX_RECEIVE_SIZE;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((read = is.read(buf)) != -1) {
            if (maxsize > 0) {
                sum = sum + read;
                if (sum > maxsize) {
                    read = maxsize - (sum - read);
                    bos.write(buf, 0, read);
                    break;
                }
            }
            bos.write(buf, 0, read);
        }

        is.close();

        response.setContent(bos.toByteArray());
        response.setHeaders(con.getHeaderFields());
        bos.close();
        if (response.getContent().length < contentLengthLimit) {
            throw new IOException("content length less than: " + String.valueOf(contentLengthLimit));
        }
        return response;
    }

    public List<String> getUserAgents() {
        return userAgents;
    }

    public void setUserAgents(List<String> userAgents) {
        this.userAgents = userAgents;
    }

    public int getConnectTimeOut() {
        return connectTimeOut;
    }

    public void setConnectTimeOut(int connectTimeOut) {
        this.connectTimeOut = connectTimeOut;
    }

    public int getReadTimeOut() {
        return readTimeOut;
    }

    public void setReadTimeOut(int readTimeOut) {
        this.readTimeOut = readTimeOut;
    }

    public int getContentLengthLimit() {
        return contentLengthLimit;
    }

    public void setContentLengthLimit(int contentLengthLimit) {
        this.contentLengthLimit = contentLengthLimit;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public Proxys getProxys() {
        return proxys;
    }

    public void setProxys(Proxys proxys) {
        this.proxys = proxys;
    }

    public static void main(String[] args) throws Exception {
        CommonHttpRequester requester = new CommonHttpRequester();
        HttpResponse response = requester.getResponse("http://localhost/test/haha.php");
        System.out.println(response.getCode());
        System.out.println(new String(response.getContent(), "utf-8"));
    }

}
