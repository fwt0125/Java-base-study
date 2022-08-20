package com.xiit.dao.network;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Tcp01 {
    public static void main(String[] args) throws IOException {
        //建立socket连接
        DatagramSocket datagramSocket = new DatagramSocket();

        //要发送的包
        String text="包里的文本内容";
        InetAddress localhost = InetAddress.getByName("localhost");
        int localhostPort = 9099;
        DatagramPacket datagramPacket = new DatagramPacket(text.getBytes(), 0, text.getBytes().length, localhost, localhostPort);

        datagramSocket.send(datagramPacket);

        datagramSocket.close();


    }
}
