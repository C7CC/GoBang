package work;

import javax.swing.*;

public class CheckWinner {
    JframeDemo jframeDemo;

    ClearChess clearChess = new ClearChess(jframeDemo);

    public CheckWinner(JframeDemo jframeDemo) {
        this.jframeDemo = jframeDemo;
    }

    /**
     * 判断五子棋胜方,每次落子时进行判断
     * n下的横坐标
     * m下的纵坐标
     */
    public void checkWinner() {
        int bcount = 0;
        int wcount = 0;
        for (int i = 0; i < 12; i++) {// 横向判断
            for (int j = 0; j < 12; j++) {
                // 判断黑棋
                if (jframeDemo.chess[i][j] == 1 || jframeDemo.chess[i][j] == 11) {
                    bcount++;
                    if (bcount == 5) {
                        JOptionPane.showMessageDialog(jframeDemo, "黑棋胜利");
                        clearChess.clearChess();
                        return;
                    }
                } else {
                    bcount = 0;
                }
                // 判断白棋
                if (jframeDemo.chess[i][j] == 2 || jframeDemo.chess[i][j] == 22) {
                    wcount++;
                    if (wcount == 5) {
                        JOptionPane.showMessageDialog(jframeDemo, "白棋胜利");
                        clearChess.clearChess();
                        return;
                    }
                } else {
                    wcount = 0;
                }
            }
        }
        for (int i = 0; i < 12; i++) {// 竖向判断
            for (int j = 0; j < 12; j++) {
                if (jframeDemo.chess[j][i] == 1 || jframeDemo.chess[j][i] == 11) {
                    bcount++;
                    if (bcount == 5) {
                        JOptionPane.showMessageDialog(jframeDemo, "黑棋胜利");
                        clearChess.clearChess();
                        return;
                    }
                } else {
                    bcount = 0;
                }
                if (jframeDemo.chess[j][i] == 2 || jframeDemo.chess[j][i] == 22) {
                    wcount++;
                    if (wcount == 5) {
                        JOptionPane.showMessageDialog(jframeDemo, "白棋胜利");
                        clearChess.clearChess();
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
                    if (jframeDemo.chess[i + k][j + k] == 1 || jframeDemo.chess[i + k][j + k] == 11) {
                        bcount++;
                        if (bcount == 5) {
                            JOptionPane.showMessageDialog(jframeDemo, "黑棋胜利");
                            clearChess.clearChess();
                            return;
                        }
                    } else {
                        bcount = 0;
                    }
                    if (jframeDemo.chess[i + k][j + k] == 2 || jframeDemo.chess[i + k][j + k] == 22) {
                        wcount++;
                        if (wcount == 5) {
                            JOptionPane.showMessageDialog(jframeDemo, "白棋胜利");
                            clearChess.clearChess();
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
                    if (jframeDemo.chess[i - k][j + k] == 1 || jframeDemo.chess[i - k][j + k] == 11) {
                        bcount++;
                        if (bcount == 5) {
                            JOptionPane.showMessageDialog(jframeDemo, "黑棋胜利");
                            clearChess.clearChess();
                            return;
                        }
                    } else {
                        bcount = 0;
                    }
                    if (jframeDemo.chess[i - k][j + k] == 2 || jframeDemo.chess[i - k][j + k] == 22) {
                        wcount++;
                        if (wcount == 5) {
                            JOptionPane.showMessageDialog(jframeDemo, "白棋胜利");
                            clearChess.clearChess();
                            return;
                        }
                    } else {
                        wcount = 0;
                    }
                }
            }
        }
    }
}

