package com.zxq.shiyanyi;


/**三角形类
 * Created by zhuxinquan on 16-4-13.
 */
public class Triangle {
    double side1;
    double side2;
    double side3;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getArea(){
        double s = (side1 + side2 + side3)/2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double getVol(){
        return side1 + side2 + side3;
    }
}
