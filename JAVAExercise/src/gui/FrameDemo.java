package gui;

import java.awt.*;

/**
 * Created by zhuxinquan on 16-8-17.
 */
public class FrameDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setTitle("title");
        frame.setSize(300, 300);
        frame.setBackground(Color.cyan);
        //设置不允许用户调整大小
        frame.setResizable(false);
        frame.setLocation(500,300);
        frame.setVisible(true);
    }
}
