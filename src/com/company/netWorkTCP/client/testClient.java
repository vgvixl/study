package com.company.netWorkTCP.client;

import com.company.netWorkTCP.password;

import java.io.*;
import java.net.Socket;

/**
 * @Auther: zzx
 * @Date: 2022.05.22/5/12
 */
public class testClient {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1",8888);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("哈哈，你好");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        password password = new password();
        password.setPwd("123456");
        password.setUser("root");
        objectOutputStream.writeObject(password);

        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String s = dataInputStream.readUTF();
        System.out.println(s);


        dataInputStream.close();
        inputStream.close();
        dataOutputStream.close();
        outputStream.close();
        socket.close();
    }
}
