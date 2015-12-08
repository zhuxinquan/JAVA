/**
 * Created by zhuxinquan on 15-11-22.
 */


package xiyou;
import xiyou.chapter4.Circle;
class Ball extends Circle{
    Ball(){};
    Ball(double r){
        super(r);
    }
    void print(){
        System.out.println("radius = " + radius);
        System.out.println("Area = "+ getArea());
        System.out.println("Perimeter = "+ getPerimeter());
        //Circle obj = new Ball();
        Ball object = new Ball(1);
        System.out.println("radius = " + object.radius);
        System.out.println("Area = "+ object.getArea());
        System.out.println("Perimeter = "+ object.getPerimeter());
    }
}
public class Ex4_27 {
    public static void main(String[] args){
        Ball obj = new Ball(10);
        obj.print();
    }
}
