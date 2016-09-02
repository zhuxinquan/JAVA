package gui;

import java.awt.*;
import java.net.URL;

/**
 * Created by zhuxinquan on 16-8-17.
 */
public class ToolketDemo extends Frame {
    public ToolketDemo(){
        this.setTitle("title");
        this.setSize(600, 400);
        this.setBackground(Color.cyan);
        //设置不允许用户调整大小
//        this.setResizable(false);

        //获取工具箱对象
        Toolkit toolkit =  Toolkit.getDefaultToolkit();
        //获取当前屏幕的尺寸
        Dimension d = toolkit.getScreenSize();
        double h = d.getHeight();
        double w = d.getWidth();

        this.setLocation((int)(w - 600)/2,(int)(h - 400)/2);
        this.setLayout(new FlowLayout());

        URL url = this.getClass().getClassLoader().getResource("gui/desktop.jpg");
        Image image = toolkit.getImage(url);
        this.setIconImage(image);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ToolketDemo();
    }
}
