package com.zxq.shiyansan;

/**
 * Created by zhuxinquan on 16-4-13.
 */
public class TriangularPyramid extends Triangle{
    double height;

    public TriangularPyramid(double height) {
        this.height = height;
    }

    public TriangularPyramid(double side1, double side2, double side3, double height) {
        super(side1, side2, side3);
        this.height = height;
    }

    public double getVol(){
        return (super.getArea() * height)/3;
    }

    public double getArea() {
        return 0;
    }
}
