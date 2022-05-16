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
public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(8888);

        byte[] b = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b,b.length, InetAddress.getByName("127.0.0.1"),9999);
        ds.receive(dp);

        byte[] data = dp.getData();
        String s = new String(data);
        System.out.println(s);

        String d = "我不好";
        dp.setData(d.getBytes());
        ds.send(dp);

        ds.close();

    }
}
