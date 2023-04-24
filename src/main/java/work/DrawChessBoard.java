package work;

import java.awt.*;

public class DrawChessBoard {

    public void drawChessBoard(Graphics g) {
        // 画棋盘
        for (int i = 50; i <= 600; i += 50) {
            g.setColor(Color.WHITE);
            g.drawLine(i, 50, i, 600);
            g.drawLine(50, i, 600, i);
        }
    }
}
