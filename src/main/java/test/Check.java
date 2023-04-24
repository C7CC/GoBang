package test;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class Check {

    int[][] table;

    public Check(int[][] table) {
        this.table = table;
    }

    public void checkWinner() {
        int bcount = 0;
        int wcount = 0;
        for (int i = 0; i < 12; i++) {// 横向判断
            for (int j = 0; j < 12; j++) {
                // 判断黑棋
                if (table[i][j] == 1 || table[i][j] == 11) {
                    bcount++;
                    if (bcount == 5) {
                        System.out.println("黑棋胜利");
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("是否重写来一局(Y/N)");
                        String going = scanner.next();
                        if (going.toUpperCase().equals("Y"))
                            clearChess();
                        else System.exit(0);
                        return;
                    }
                } else {
                    bcount = 0;
                }
                // 判断白棋
                if (table[i][j] == 2 || table[i][j] == 22) {
                    wcount++;
                    if (wcount == 5) {
                        System.out.println("白棋胜利");
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("是否重写来一局(Y/N)");
                        String going = scanner.next();
                        if (going.toUpperCase().equals("Y"))
                            clearChess();
                        else System.exit(0);
                        return;
                    }
                } else {
                    wcount = 0;
                }
            }
        }
        for (int i = 0; i < 12; i++) {// 竖向判断
            for (int j = 0; j < 12; j++) {
                if (table[j][i] == 1 || table[j][i] == 11) {
                    bcount++;
                    if (bcount == 5) {
                        System.out.println("黑棋胜利");
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("是否重写来一局(Y/N)");
                        String going = scanner.next();
                        if (going.toUpperCase().equals("Y"))
                            clearChess();
                        else System.exit(0);
                        return;
                    }
                } else {
                    bcount = 0;
                }
                if (table[j][i] == 2 || table[j][i] == 22) {
                    wcount++;
                    if (wcount == 5) {
                        System.out.println("白棋胜利");
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("是否重写来一局(Y/N)");
                        String going = scanner.next();
                        if (going.toUpperCase().equals("Y"))
                            clearChess();
                        else System.exit(0);
                        return;
                    }
                } else {
                    wcount = 0;
                }
            }
        }
        for (int i = 0; i < 8; i++) {// 左向右斜判断
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 5; k++) {
                    if (table[i + k][j + k] == 1 || table[i + k][j + k] == 11) {
                        bcount++;
                        if (bcount == 5) {
                            System.out.println("黑棋胜利");
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("是否重写来一局(Y/N)");
                            String going = scanner.next();
                            if (going.toUpperCase().equals("Y"))
                                clearChess();
                            else System.exit(0);
                            return;
                        }
                    } else {
                        bcount = 0;
                    }
                    if (table[i + k][j + k] == 2 || table[i + k][j + k] == 22) {
                        wcount++;
                        if (wcount == 5) {
                            System.out.println("白棋胜利");
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("是否重写来一局(Y/N)");
                            String going = scanner.next();
                            if (going.toUpperCase().equals("Y"))
                                clearChess();
                            else System.exit(0);
                            return;
                        }
                    } else {
                        wcount = 0;
                    }
                }
            }
        }
        for (int i = 4; i < 12; i++) {// 右向左斜判断 11->12
            for (int j = 7; j >= 0; j--) {
                for (int k = 0; k < 5; k++) {
                    if (table[i - k][j + k] == 1 || table[i - k][j + k] == 11) {
                        bcount++;
                        if (bcount == 5) {
                            System.out.println("黑棋胜利");
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("是否重写来一局(Y/N)");
                            String going = scanner.next();
                            if (going.toUpperCase().equals("Y"))
                                clearChess();
                            else System.exit(0);
                            return;
                        }
                    } else {
                        bcount = 0;
                    }
                    if (table[i - k][j + k] == 2 || table[i - k][j + k] == 22) {
                        wcount++;
                        if (wcount == 5) {
                            System.out.println("白棋胜利");
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("是否重写来一局(Y/N)");
                            String going = scanner.next();
                            if (going.toUpperCase().equals("Y"))
                                clearChess();
                            else System.exit(0);
                            return;
                        }
                    } else {
                        wcount = 0;
                    }
                }
            }
        }
    }

    public void clearChess() {
        for (int[] ints : table) {
            Arrays.fill(ints, 0);
        }
    }
}
