package xiyou.chapter4;

import java.security.PublicKey;

public class Circle{
    protected double radius;
    public Circle(){};
    public Circle(double radius){
        this.radius = radius;
    }
    protected double getArea(){
        return radius*radius*Math.PI;
    }
    protected double getPerimeter(){
        return 2*radius*Math.PI;
    }
}
