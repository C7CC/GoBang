package work;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class sendXY {
    JframeDemo jframeDemo;

    public sendXY(JframeDemo jframeDemo) {
        this.jframeDemo = jframeDemo;
    }

    public void send(int x, int y) {
        try {
            Socket socket = new Socket(jframeDemo.inetAddress, jframeDemo.serverPort);
            OutputStream outputStream = socket.getOutputStream();
            String send = x + "-" + y;
            outputStream.write(send.getBytes());
            socket.shutdownOutput();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "网络问题", "网络问题", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
