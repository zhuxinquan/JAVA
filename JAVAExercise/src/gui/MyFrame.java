package gui;

import java.awt.*;

/**
 * Created by zhuxinquan on 16-8-17.
 */
public class MyFrame extends Frame {
    public MyFrame(){
        this.setTitle("title");
        this.setSize(300, 300);
        this.setBackground(Color.cyan);
        //设置不允许用户调整大小
        this.setResizable(false);
        this.setLocation(500,300);
        this.setLayout(new FlowLayout());
        //在窗体上添加按钮
        Button b1 = new Button("Button1");
        this.add(b1);
        Button b2 = new Button("Button2");
        this.add(b2);


        //显示
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
