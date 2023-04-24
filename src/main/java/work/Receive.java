package work;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receive {
    JframeDemo jframeDemo;

    public Receive(JframeDemo jframeDemo) {
        this.jframeDemo = jframeDemo;
    }

    public void receive() throws IOException {
        ChangeChess doit = new ChangeChess(jframeDemo);
        CheckWinner checkWinner = new CheckWinner(jframeDemo);

        ServerSocket serverSocket = new ServerSocket(jframeDemo.clientPort);
        //接收数据
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = inputStream.read(bytes);
            String s = new String(bytes, 0, len);
            String[] split = s.split("-");
            jframeDemo.ex = Integer.parseInt(split[0]);
            jframeDemo.ey = Integer.parseInt(split[1]);
            doit.doit();
            checkWinner.checkWinner();
            jframeDemo.one = true;
        }


    }
}
