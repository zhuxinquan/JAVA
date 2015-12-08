/**
 * Created by zhuxinquan on 15-11-24.
 */

class Circle{
    double radius = 10;
    public Circle(){
        //this(0);
        System.out.println("Parent radius"+radius);
    }
    public Circle(double r){
        radius = r;
        System.out.println("Parent radius"+radius);
    }
}

class Cylinder extends Circle{
    double height = 100;
    public Cylinder(){
        System.out.println("height"+height);
    }
}

public class Ex5_5 {
    public static void main(String[] args){
        Cylinder obj = new Cylinder();
        System.out.println(obj.radius);
    }
}
