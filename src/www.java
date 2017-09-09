import org.junit.Test;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2017/6/5.
 */
public class www {
    int i;
    JFrame frame;  //窗体,是整个迷宫的容器
    JPanel panel;
    JButton button[];

    @Test
    public void fo() {
        FindPath ai = new FindPath();
    }

    public void dT() {
        int i;
        frame = new JFrame("qqq");
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
}
