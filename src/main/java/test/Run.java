package test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Run {

    static int[][] table = new int[12][12];
    static Check check = new Check(table);
    static int color;//棋子颜色
    static boolean turn;//记录轮到谁
    static String ip_me;

    static {
        try {
            ip_me = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 规定黑子为1，白子为2
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        receive receive = new receive(table);
        receive.start();
        send send = new send();

        System.out.println("欢迎来到五子棋时间,规则用落子位置间用“-”进行间隔,祝您有愉快的一天");
        System.out.println("你当前的ip:" + ip_me);
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("请输入要连接的ip:");
        String ip = scanner1.next();
        send.send3();

        if (Run.color == 0) {//没人选择先后手
            System.out.println("请问您是否为先手(Y/N)");
            Scanner scanner2 = new Scanner(System.in);
            String upperCase = scanner2.next().toUpperCase();
            if (upperCase.equals("Y")) {
                send.send2("先手");
                Run.color = 1;
                turn = true;
            } else {
                send.send2("后手");
                Run.color = 2;
                turn = false;
            }
        } else {//先后手已定
            System.out.println("先后手已定");
            if (Run.color == 1)
                System.out.println("您为先手");
            else
                System.out.println("您为后手");
        }

        boolean flag = true;
        while (flag) {
            if (turn) {
                //棋盘
                //第一行第一列都为索引列
                for (int i = -1; i < 12; i++) {
                    for (int j = -1; j < 12; j++) {
                        if (i == -1) System.out.print(j + "\t");
                        else if (j == -1) System.out.print(i + "\t");
                        else
                            System.out.print(table[i][j] + "\t");
                    }
                    System.out.println();
                }
                turn = false;
                Scanner scanner = new Scanner(System.in);
                String next = scanner.next();
                String[] split = next.split("-");
                //发送落子位置
                try {
                    int m = Integer.parseInt(split[0]), n = Integer.parseInt(split[1]);
                    send.send(m, n, ip);
                    table[m][n] = Run.color;
                    check.checkWinner();
                } catch (NullPointerException e) {
                    System.out.println("请按规定格式输入");
                }
            } else {
                System.out.println("还未轮到您下棋,请耐心等待");
            }
        }
    }
}
