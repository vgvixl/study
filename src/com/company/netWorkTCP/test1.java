package com.company.netWorkTCP;

import java.net.*;

/**
 * @Auther: zzx
 * @Date: 2022.05.22/5/11
 */
public class test1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
        System.out.println(loopbackAddress);
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        InetSocketAddress socketAddress = InetSocketAddress.createUnresolved("127.0.0.1", 8888);
    }
}
