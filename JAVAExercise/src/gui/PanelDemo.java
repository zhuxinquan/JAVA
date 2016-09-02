package gui;

import java.awt.*;

/**
 * Created by zhuxinquan on 16-8-17.
 */
public class PanelDemo extends Frame {
    public PanelDemo(){
        this.setTitle("title");
        this.setSize(600, 400);
        this.setBackground(Color.cyan);
        //设置不允许用户调整大小
        this.setResizable(false);
        this.setLocation(500,300);
        this.setLayout(new FlowLayout());
        addPanel();
        this.setVisible(true);
    }

    public void addPanel(){
        Panel p1 = new Panel();
        p1.setBackground(Color.cyan);
        p1.add(new Button("this is Button"));
        p1.add(new Button("this is Button"));
        p1.add(new Button("this is Button"));
        //将面板添加到窗体上
        this.add(p1);
    }

    public static void main(String[] args) {
        new PanelDemo();
    }
}
