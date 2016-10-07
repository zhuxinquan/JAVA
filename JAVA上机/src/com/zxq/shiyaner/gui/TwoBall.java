package com.zxq.shiyaner.gui;

/**
 * Created by zhuxinquan on 16-9-28.
 */
import java.awt.*;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/**
 * 11．编写一个Java GUI应用程序，采用Java多线程技术，模拟自由落体和平抛运动：一个球自由落下，一个球水平抛出。（本题30分）
 （自由落体物理公式：h= g *t2/2 ；平抛运动物理公式：h= g *t2/2 ，x=26*t ；
 h代表高度，t代表时间，g代表重力加速度=9.8 m/s2 ）
 * */
public class TwoBall {

    public static void main(String[] args){
        TwoBalls ball=new TwoBalls();
        ball.init();
        ball.start();
    }


}

class TwoBalls extends JFrame{
    javax.swing.JRadioButton ball1=new JRadioButton();
    javax.swing.JRadioButton ball2=new JRadioButton();

    int width=20;
    int height=20;

    int ball1X=10;
    int ball1Y=10;
    int ball2X=10;
    int ball2Y=10;

    int windowWidth=800;
    int windowHeight=600;

    double g=9.8;
    int t=1;//ms

    public void init(){
        this.getContentPane().setLayout(null);
        ball1.setBounds(10,10,10,10);
        ball2.setBounds(10,10,10,10);

        ball1.setSelected(true);
        ball2.setSelected(true);

        this.getContentPane().add(ball1);
        this.getContentPane().add(ball2);

        this.validate();
        this.setVisible(true);
        this.setBounds(100, 100, windowWidth, windowHeight);


        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

    }
    public void start(){
        Thread t1=new Thread(){
            public void run(){
                while(true){

                    if(ball1X<windowWidth&ball1Y<windowHeight&&ball2X<windowWidth&ball2Y<windowHeight){
                        t=t+1;
                        ball1Y=(int)(g*t*t/2);
                        ball2Y=(int)(g*t*t/2);
                        ball2X=(int)26*t;

                        ball1.setBounds(ball1X,ball1Y, width, height);
                        ball2.setBounds(ball2X,ball2Y,width,height);

                    }
                    else{
                        ball1X=10;
                        ball1Y=10;
                        ball2X=10;
                        ball2Y=10;
                        t=1;
                    }

                    try{
                        this.sleep(30);
                    }catch(Exception e){}


                }

            }
        };

        t1.start();
    }

}