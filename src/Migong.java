import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2017/6/5.
 */
public class Migong {
    private int[][] arrs = new int[10][10];
    private Stack s = new Stack();

    @Test
    public void doTest() {
        int[][] arrs = doCreat();
        //走之前
        doprint(arrs);
        s.push(arrs[1][7]);
        domian(1, 7);
    }

    private void domian(int i, int j) {
        String top = dotop(i, j);
        String left = doleft(i, j);
        String follow = dofollow(i, j);
        String right = doright(i, j);
        List list = new ArrayList();
        list.add(top);
        list.add(left);
        list.add(follow);
        list.add(right);
        if (list.contains("true")) {
            if (list.indexOf("true") != list.lastIndexOf("true")) {
                //有分叉路
                
                if (left.equals("true")) {
                    domian(i, j - 1);
                }
            }
        }
    }

    //向上找
    private String dotop(int i, int j) {
        if (i >= 1) {
            if (arrs[i - 1][j] == 9) {
                return "end";
            }
            if (arrs[i - 1][j] == 1) {
                //已访问过的设为2
                arrs[i - 1][j] = 2;
                return "true";
            }
            arrs[i - 1][j] = 2;
        }
        return "false";
    }

    //向下找
    private String dofollow(int i, int j) {
        if (i <= 8) {
            if (arrs[i + 1][j] == 9) {
                return "end";
            }
            if (arrs[i + 1][j] == 1) {
                //已访问过的设为2
                arrs[i + 1][j] = 2;
                return "true";
            }
            arrs[i + 1][j] = 2;
        }
        return "false";
    }

    //向左找
    private String doleft(int i, int j) {
        if (j >= 1) {
            if (arrs[i][j - 1] == 9) {
                return "end";
            }
            if (arrs[i][j - 1] == 1) {
                arrs[i][j - 1] = 2;
                return "true";
            }
            arrs[i][j - 1] = 2;
        }
        return "false";
    }

    //向右找
    private String doright(int i, int j) {
        if (j <= 8) {
            if (arrs[i][j + 1] == 9) {
                return "end";
            }
            if (arrs[i][j + 1] == 1) {
                arrs[i][j + 1] = 2;
                return "true";
            }
            arrs[i][j + 1] = 2;
        }
        return "false";
    }

    private int[][] doCreat() {
        arrs[1][1] = 1;
        arrs[1][2] = 1;
        arrs[1][6] = 1;
        arrs[1][7] = 4;
        arrs[2][1] = 1;
        arrs[2][2] = 1;
        arrs[2][5] = 1;
        arrs[2][6] = 1;
        arrs[2][8] = 1;
        arrs[3][1] = 1;
        arrs[3][2] = 1;
        arrs[3][3] = 1;
        arrs[3][4] = 1;
        arrs[3][5] = 1;
        arrs[3][6] = 1;
        arrs[3][8] = 1;
        arrs[4][1] = 1;
        arrs[4][2] = 1;
        arrs[4][3] = 1;
        arrs[4][4] = 1;
        arrs[4][7] = 1;
        arrs[4][8] = 1;
        arrs[5][1] = 1;
        arrs[5][2] = 1;
        arrs[5][6] = 1;
        arrs[5][7] = 1;
        arrs[5][8] = 1;
        arrs[6][1] = 1;
        arrs[6][2] = 1;
        arrs[6][3] = 1;
        arrs[6][4] = 1;
        arrs[6][6] = 1;
        arrs[6][8] = 1;
        arrs[7][1] = 1;
        arrs[7][4] = 1;
        arrs[7][5] = 1;
        arrs[7][6] = 1;
        arrs[7][8] = 1;
        arrs[8][2] = 1;
        arrs[8][3] = 1;
        arrs[8][4] = 1;
        arrs[8][5] = 1;
        arrs[8][7] = 1;
        arrs[8][8] = 9;
        return arrs;
    }

    private void doprint(int[][] arrs) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(arrs[i][j] + "    ");
            }
            System.out.println();
        }
    }
}
