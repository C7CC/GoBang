package work;

public class ChangeChess {
    JframeDemo jframeDemo;
    CheckWinner checkWinner = new CheckWinner(jframeDemo);

    public ChangeChess(JframeDemo jframeDemo) {
        this.jframeDemo = jframeDemo;
    }

    /**
     * 下棋
     * 判断子颜色和胜方
     */
    @SuppressWarnings("all")
    public void doit() {
        //棋子位置
        jframeDemo.x = (jframeDemo.ex - 19) / 50;
        jframeDemo.y = (jframeDemo.ex - 19) / 50;

        /**
         * 普通白子11，特殊白子1
         * 普通黑子22，特殊黑子2
         */
        if (jframeDemo.chess[jframeDemo.x][jframeDemo.y] == 0) {//此处无子
            if (jframeDemo.me == true) {//黑棋
                jframeDemo.chess[jframeDemo.x][jframeDemo.y] = 11;
                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 12; j++) {
                        if (jframeDemo.chess[i][j] == 22) {
                            jframeDemo.chess[i][j] = 2;//特殊白子变普通
                        }
                    }
                }
                jframeDemo.me = false;//变白子
            } else if (jframeDemo.me == false) {//白棋
                jframeDemo.chess[jframeDemo.x][jframeDemo.y] = 22;
                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 12; j++) {
                        if (jframeDemo.chess[i][j] == 11) {
                            jframeDemo.chess[i][j] = 1;//特殊黑子变普通
                        }
                    }
                }
                jframeDemo.me = true;//变黑子
            }
        }
        jframeDemo.repaint();//重画棋盘
    }
}
