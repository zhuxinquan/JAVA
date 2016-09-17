package com.zxq.shiyanyi;

/**
 * 三棱柱
 * Created by zhuxinquan on 16-4-13.
 */
public class Prism extends Triangle{
    double height;

    public Prism(double side1, double side2, double side3, double height){
        super(side1, side2, side3);
        this.height = height;
    }

    public double getArea(){
        return super.getVol() * height + 2 * super.getArea();
    }

    public double getVol(){
        return super.getArea() * height;
    }
}
