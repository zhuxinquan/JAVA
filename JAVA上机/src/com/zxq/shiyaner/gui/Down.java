package com.zxq.shiyaner.gui;

/**
 * Created by zhuxinquan on 16-9-28.
 */
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Down extends JFrame implements Runnable{
    double x=30,y=30;     //坐标
    long t=0;   //时间
    public Down(){
        this.setSize(1200,700);
        JPanel panel =new JPanel(){
            public void paint(Graphics g){
//                for (double i = t - 1; i < t; i = i + 0.01) {
//                    x += 1*t;                //自由落体就把这行代码注掉
//                    y += (i*i)/10;
//                    y = i * i * 5;
//                    g.fillOval((int)x, (int)y, 30, 30);//画小球的位置
//                }
                x+=3*t;                //自由落体就把这行代码注掉
                y+=t*t/10;
                g.fillOval((int)x, (int)y, 40, 40);//画小球的位置
            }
        };
        this.setContentPane(panel);
        panel.setBackground(Color.red);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Down d = new Down();
        new Thread(d).start();
    }

    public void run(){                //这个线程用来不断重画我们的图面
        while(true){
            try {
                Thread.sleep(200);    //每隔100ms画一次
                t+=1;
                //重新绘制该区域
                this.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
