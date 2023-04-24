package test;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class send {

    String ip;

    public void send(int x, int y, String ip) {
        try {
            int serverPort = 8868;
            Socket socket = new Socket(ip, serverPort);
            OutputStream outputStream = socket.getOutputStream();
            String send = x + "-" + y;
            outputStream.write(send.getBytes());
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "网络问题", "网络问题", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public void send2(String send) throws IOException {
        int serverPort = 8868;
        Socket socket = new Socket(ip, serverPort);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(send.getBytes());
        outputStream.close();
        socket.close();
    }
    public void send3() throws IOException {
        int serverPort = 8868;
        Socket socket = new Socket(ip, serverPort);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(("test connection:" + Run.ip_me).getBytes());
        outputStream.close();
        socket.close();
    }

    public void send4() throws IOException {
        int serverPort = 8868;
        Socket socket = new Socket(ip, serverPort);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("ok".getBytes());
        outputStream.close();
        socket.close();
    }
}
