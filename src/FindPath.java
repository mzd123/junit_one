/**
 * Created by Administrator on 2017/6/5.
 */

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class FindPath {
    private static final int wid = 10;
    private static final int hei = 10;
    JFrame frame;  //窗体,是整个迷宫的容器
    JPanel panel;
    JButton button[];
    private Stack stack = new Stack();

    public static void main(String[] args) {
        byte[] map = {
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 0, 0, 1, 0, 0, 0, 1, 0, 1,
                1, 0, 0, 1, 0, 0, 0, 1, 0, 1,
                1, 0, 0, 0, 0, 1, 1, 0, 0, 1,
                1, 0, 1, 1, 1, 0, 0, 0, 0, 1,
                1, 0, 0, 0, 1, 0, 0, 0, 0, 1,
                1, 0, 1, 0, 0, 0, 1, 0, 0, 1,
                1, 0, 1, 1, 1, 0, 1, 1, 0, 1,
                1, 1, 0, 0, 0, 0, 0, 0, 0, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
        };
        int i = 0;
        FindPath ai = new FindPath();
        ai.find(map, 11, 88);
    }

    FindPath() {
        int i;
        frame = new JFrame("孙尧的神奇迷宫");
        frame.setBounds(300, 240, 500, 500);  //调整迷宫出现的位置及大小
        frame.setResizable(false);//窗体不可拉伸 
        panel = new JPanel();
        frame.getContentPane().add(panel);  //将面板添加到窗体中
        panel.setLayout(new GridLayout(10, 10)); //panel用网格布局,10行10列  
        button = new JButton[100];
        for (i = 0; i < button.length; i++) {
            button[i] = new JButton(Integer.toString(i)); //创建按键的名字，Integer型的名字为i的字符串
            if ((i >= 0 && i <= 9) || (i >= 90 && i <= 99) || i % 10 == 0 || i % 10 == 9 || i == 13 || i == 17 || i == 23 || i == 27 || i == 35 || i == 36 || i == 42 || i == 43 || i == 44 || i == 54 || i == 62 || i == 66 || i == 72 || i == 73 || i == 74 || i == 76 || i == 77 || i == 81) {
                button[i].setBackground(Color.red);
            } else {
                button[i].setBackground(Color.white);
            }
            button[i].setSize(10, 10);
            panel.add(button[i]);
        }

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); //声明点“X”图标后结束窗体所在的应用程序
        frame.setVisible(true);  //表明以上创建的所有窗体、按键等组件都是可见的
    }

    public void find(byte[] map, int origin, int target) {
        int[] step = new int[2];
        step[1] = origin;
        stack.addElement(step);
        if (findPath(map, origin, target)) {
            System.out.println("succ");
            for (int i = 0; i < stack.size(); i++) {
                int[] temp = (int[]) stack.elementAt(i);
                System.out.println(i + " /t" + (char) temp[0] + " " + temp[1]);
                button[temp[1]].setBackground(Color.blue);
            }
        } else {
            System.out.println("fail");
        }
    }

    public boolean findPath(byte[] map, int origin, int target) {
        if (canMoveTo(map, origin, target, 'l')) {
            return true;
        }
        if (canMoveTo(map, origin, target, 'r')) {
            return true;
        }
        if (canMoveTo(map, origin, target, 'u')) {
            return true;
        }
        if (canMoveTo(map, origin, target, 'd')) {
            return true;
        }
        stack.pop();// 如果四个方向都试过，全部不行，那么把当前步骤弹出 
        return false;
    }

    private boolean canMoveTo(byte[] map, int origin, int target, char direct) {
        int next = 0;
        switch (direct) {
            case 'l':
                next = origin - 1;
                break;
            case 'r':
                next = origin + 1;
                break;
            case 'u':
                next = origin - wid;
                break;
            case 'd':
                next = origin + wid;
                break;
        }
        if (map[next] == 0) {//如果目标位置可以进入 
            if (next == target) {
                int[] step = new int[2];
                step[0] = direct;// 移动方向 
                step[1] = next;// 到达的新位置 
                stack.addElement(step);
                return true;
            }
            if (!inStack(next)) {
                int[] step = new int[2];
                step[0] = direct;
                step[1] = next;
                stack.addElement(step);
                if (findPath(map, next, target)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean inStack(int posi) {
        int[] temp;
        for (int i = stack.size() - 1; i >= 0; i--) {
            temp = (int[]) stack.elementAt(i);
            if (posi == temp[1]) {
                return true;
            }
        }
        return false;
    }
} 
