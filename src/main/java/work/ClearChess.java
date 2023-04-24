package work;

import java.util.Arrays;

public class ClearChess {
    JframeDemo jframeDemo;

    public ClearChess(JframeDemo jframeDemo) {
        this.jframeDemo = jframeDemo;
    }

    /**
     * 初始化棋盘
     */
    public void clearChess() {
        for (int[] chess : jframeDemo.chess) {
            Arrays.fill(chess, 0);
        }
        jframeDemo.me = true;//己方为黑子(先手)
        jframeDemo.repaint();//绘图
    }
}
