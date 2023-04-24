package work;

import java.awt.*;

public class DrawChess {
    public void drawChess(Graphics g) {

        JframeDemo jDemo = new JframeDemo();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (jDemo.chess[i][j] == 1) {
                    g.setColor(Color.black);
                    g.fillOval((i + 1) * 50 - 19, (j + 1) * 50 - 19, 38, 38);
                } else if (jDemo.chess[i][j] == 2) {
                    g.setColor(Color.white);
                    g.fillOval((i + 1) * 50 - 19, (j + 1) * 50 - 19, 38, 38);
                } else if (jDemo.chess[i][j] == 11) {// 点击落黑子时外加个黑框
                    g.setColor(Color.black);
                    g.fillOval((i + 1) * 50 - 19, (j + 1) * 50 - 19, 38, 38);
                    g.drawRect((i + 1) * 50 - 19, (j + 1) * 50 - 19, 38, 38);
                } else if (jDemo.chess[i][j] == 22) {// 点击落白子时棋子外加个白框
                    g.setColor(Color.white);
                    g.fillOval((i + 1) * 50 - 19, (j + 1) * 50 - 19, 38, 38);
                    g.drawRect((i + 1) * 50 - 19, (j + 1) * 50 - 19, 38, 38);
                }
            }
        }
    }
}
