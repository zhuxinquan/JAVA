package com.zxq.shiyansan;

/**
 * 长方体
 * Created by zhuxinquan on 16-4-13.
 */
public class Cube extends Rectangle {
    double height;
    public Cube(){
        super();
        width = 10;
        length = 10;
        height = 10;
    }
    public Cube(double width1, double length1, double height){
        width = width1;
        length = length1;
        this.height = height;
    }

    public Cube(int width1, int length1, int height){
        width = width1;
        length = length1;
        this.height = height;
    }

    public double getVol(){
        return width * length * height;
    }
    public double getArea(){
        return 2*(width * length + width * height + length * height);
    }
}
