package com.company.netWorkUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Auther: zzx
 * @Date: 2022.05.22/5/12
 */
public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(9999);


        byte[] b = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b,b.length, InetAddress.getByName("127.0.0.1"),8888);
        String s = "你好";
        dp.setData(s.getBytes());
        ds.send(dp);

        DatagramPacket dp2 = new DatagramPacket(b,b.length, InetAddress.getByName("127.0.0.1"),8888);
        ds.receive(dp2);

        byte[] data = dp2.getData();
        String g = new String(data);
        System.out.println(g);

        ds.close();
    }
}
