package com.company.netWorkTCP.service;

import com.company.netWorkTCP.password;

import java.io.*;
import java.net.Socket;

/**
 * @Auther: zzx
 * @Date: 2022.05.22/5/12
 */
public class serverThread extends Thread{
    Socket socket ;
    public serverThread(Socket s){
        this.socket = s;
    }
    @Override
    public void run() {
        InputStream inputStream = null;
        DataInputStream dataInputStream = null;
        ObjectInputStream objectInputStream = null;
        OutputStream outputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            inputStream = socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            String s = dataInputStream.readUTF();
            System.out.println(s);

            objectInputStream = new ObjectInputStream(inputStream);
            Object o = objectInputStream.readObject();
            if (o instanceof password) {
                password o1 = (password) o;
                System.out.println(o1);
            }
            outputStream = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF("嘻嘻");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
