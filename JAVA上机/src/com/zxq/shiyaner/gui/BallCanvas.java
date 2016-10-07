package com.zxq.shiyaner.gui;

/**
 * Created by zhuxinquan on 16-9-28.
 */
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

/**

 * 类说明：编写一个Java GUI应用程序，采用Java多线程技术，模拟自由落体和平抛运动：
 * 一个球自由落下，一个球水平抛出。（本题30分）
 * （自由落体物理公式：h= g *t2/2 ；平抛运动物理公式：h= g *t2/2 ，x=26*t ；
 *  h代表高度，t代表时间，g代表重力加速度=9.8
 * m/s2 ）
 */

public class BallCanvas extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    private int h = 0;// 高度
    private final float G = 9.8f;// 重力加速度
    private final int D = 20;// 小球直径
    private float t = 0;// 时间
    private int x = 0;// 水平位移
    private int v = 36;// 平抛初始速度

    public BallCanvas() {
        new Thread(this).start();
    }

    public void run() {

        // 利用线程的死循环模拟小球运动过程
        while (true) {
            t += 0.2;
            x = (int) (v * t);// 水平位移
            h = (int) (G * t * t / 2);// 下落高度
            repaint();
            if (x > this.getWidth() || h > this.getHeight()) {
                t = 0;
                x = 0;
                h = 0;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public void paint(Graphics g) {

        // 重新绘制屏幕
        // g.setColor(Color.white);
        // g.fillRect(0, 0, this.getWidth(), this.getHeight());
        //  画出小球图形
        g.setColor(Color.red);
        g.fillArc(x, h, D, D, 0, 360);
        g.setColor(Color.blue);
        g.fillArc(0, h, D, D, 0, 360);
    }


    public static void main(String[] args) {

        // 创建出可视化窗口
        JFrame frame = new JFrame("斜抛和自由落体运动");
        // 获得该窗口的容器
        Container con = frame.getContentPane();
        // 往该容器中添加Canvas组件
        // Canvas 组件表示屏幕上一个空白矩形区域，
        // 应用程序可以在该区域内绘图，或者可以从该区域捕获用户的输入事件。
        con.add(new BallCanvas(), BorderLayout.CENTER);

        //将组件的首选大小设置为常量值
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setVisible(true);
        //确保组件具有有效的布局。
        frame.validate();
        // 将窗口设置为屏幕正中央
        frame.setLocationRelativeTo(null);
        // 设置窗口关闭按钮操作有效
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

    }
}

