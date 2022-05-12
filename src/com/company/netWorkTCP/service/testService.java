package com.company.netWorkTCP.service;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: zzx
 * @Date: 2022.05.22/5/12
 */
public class testService {
    public static void main(String[] args) throws Exception{
        //注册socket服务
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true){
            Socket accept = serverSocket.accept();
            serverThread thread = new serverThread(accept);
            thread.start();
            System.out.println("===========");
        }

    }
}
