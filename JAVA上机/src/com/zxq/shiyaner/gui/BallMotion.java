package com.zxq.shiyaner.gui;

/**
 * Created by zhuxinquan on 16-9-28.
 */
import java.awt.*;
import java.awt.event.*;

public class BallMotion {
    public static void main(String args[]) {
        MyFrame frame = new MyFrame();
        frame.setBounds(10, 10, 500, 500);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class MyFrame extends Frame implements Runnable {
    Thread redThread, blueThread;
    MyCanvas red, blue;
    double t = 0;
    MyFrame() {
        super.setTitle("斜抛和自由落体运动");
        redThread = new Thread(this);
        blueThread = new Thread(this);
        red = new MyCanvas(Color.red);
        blue = new MyCanvas(Color.blue);
        setLayout(null);
        add(red);
        add(blue);
        red.setLocation(60, 100);
        blue.setLocation(60, 100);
        redThread.start();
        blueThread.start();
    }

    public void run() {
        while (true) {
            t = t + 0.1;
            if (t > 20)
                t = 0;
            if (Thread.currentThread() == redThread) {
                int x = 60;
                int h = (int) (1.0 / 2 * t * t * 3.8) + 60;
                red.setLocation(x, h);
                try {
                    redThread.sleep(50);
                } catch (InterruptedException e) {
                }
            } else if (Thread.currentThread() == blueThread) {
                int x = 60 + (int) (26 * t);
                int h = (int) (1.0 / 2 * t * t * 3.8) + 60;
                blue.setLocation(x, h);
                try {
                    blueThread.sleep(50);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}

class MyCanvas extends Canvas {
    Color c;

    MyCanvas(Color c) {
        setSize(20, 20);
        this.c = c;
    }

    public void paint(Graphics g) {
        g.setColor(c);
        g.fillOval(0, 0, 20, 20);
    }
}
