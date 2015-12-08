
/**
 * Created by zhuxinquan on 15-11-22.
 */

class Circle{
    private double radius;
    public void setRadius(double radius){
        this.radius = radius;
    }
    private double getRadius(){
        return radius;
    }
    private double getArea(){
        return radius*radius*Math.PI;
    }
    public double getPerimeter(){
        return 2*radius*Math.PI;
    }
}

public class Ex4_25 {
    public static void main(String[] args){
       Circle obj = new Circle();
        obj.setRadius(10);
        //System.out.println("Area = " + obj.getArea());
        System.out.println("Perimeter="+obj.getPerimeter());
    }
}
