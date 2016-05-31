package com.zxq.shiyansan;

/**圆柱体
 * Created by zhuxinquan on 16-4-13.
 */
public class Cylinder extends Circle{
    double height;

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getArea(){
        return super.getVol() * height + 2 * super.getArea();
    }

    public double getVol(){
        return super.getArea() * height;
    }
}
