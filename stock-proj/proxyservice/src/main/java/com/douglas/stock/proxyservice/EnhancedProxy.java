package com.douglas.stock.proxyservice;

import java.net.Proxy;
import java.net.SocketAddress;
import java.util.Date;

/**
 * Created by wgz on 15/4/2.
 */
public class EnhancedProxy extends Proxy {
    private float respondIntervalMs;
    private Date last = null;
    private static int reuseInterval = 5000;
    private boolean valid = true;

    /**
     * Creates an entry representing a PROXY connection.
     * Certain combinations are illegal. For instance, for types Http, and
     * Socks, a SocketAddress <b>must</b> be provided.
     * <p/>
     * Use the <code>Proxy.NO_PROXY</code> constant
     * for representing a direct connection.
     *
     * @param type the <code>Type</code> of the proxy
     * @param sa   the <code>SocketAddress</code> for that proxy
     * @throws IllegalArgumentException when the type and the address are
     *                                            incompatible
     */
    public EnhancedProxy(Type type, SocketAddress sa, int intreval) {
        super(type, sa);
        respondIntervalMs = intreval;
    }

    public static int getReuseInterval() {
        return reuseInterval;
    }

    public static void setReuseInterval(int reuseInterval) {
        EnhancedProxy.reuseInterval = reuseInterval;
    }

    public synchronized boolean useIfUsable() {
        Date now = new Date();
        if (last == null || now.getTime() - last.getTime() >= reuseInterval) {
            last = now;
            return true;
        }
        return false;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public float getRespondIntervalMs() {
        return respondIntervalMs;
    }

    public void setRespondIntervalMs(float respondIntervalMs) {
        this.respondIntervalMs = respondIntervalMs;
    }


}
