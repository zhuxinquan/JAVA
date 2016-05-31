package com.zxq.shiyansan;

/**
 * Created by zhuxinquan on 16-4-13.
 */
public class Circle {
    double radius;

    public Circle() {
        radius = 1;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }

    public double getVol(){
        return Math.PI * 2 * radius;
    }
}
