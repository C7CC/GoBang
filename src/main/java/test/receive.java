package test;

import org.junit.jupiter.api.Test;

import java.beans.Transient;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class receive extends Thread {

    int[][] table;

    public receive(int[][] table) {
        this.table = table;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        send send = new send();
        try {
            serverSocket = new ServerSocket(8868);
            //接收数据
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int len = inputStream.read(bytes);
                String s = new String(bytes, 0, len);
                System.out.println(s);
                if (s.length() >= 15 && s.substring(0 ,15).equals("test connection")) {
                    System.out.println("接收到连接请求");
                    send.send4();
                } else if (s.equals("ok")) {
                    System.out.println("连接成功");
                } else if (s.equals("先手")) {
                    Run.color = 2;//对方为1，先手
                    Run.turn = false;//等待对方落子
                } else if (s.equals("后手")) {
                    Run.color = 1;//对方为2，后手
                    Run.turn = true;//先手可以落子
                } else {
                    String[] split = s.split("-");
                    int n = Integer.parseInt(split[0]), m = Integer.parseInt(split[1]);
                    table[n][m] = Run.color;
                    Run.turn = true;//接收到对方落子后现在可以落子
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class test {
    public static void main(String[] args) {
        System.out.println("test".substring(0 ,4));
    }
}