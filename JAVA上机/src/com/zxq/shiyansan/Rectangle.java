package com.zxq.shiyansan;

/**
 * 矩形
 * Created by zhuxinquan on 16-4-13.
 */
public class Rectangle {
    double width;
    double length;

    public Rectangle() {
    }

    public double getCicle(){
        return 2*(width + length);
    }

    public double getArea(){
        return width * length;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }
}
