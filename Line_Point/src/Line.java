import java.awt.*;

/**
 * Created by zhuxinquan on 15-11-23.
 */

class Point{
    int x;
    int y;
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public String toString(){
        return "("+x+","+y+")";
    }
}

class operate{
    public double distance(Point a, Point b){
        return Math.sqrt((a.x - b.x)*(a.x - b.x)+(a.y -b.y)*(a.y -b.y));
    }
}

public class Line{
    public static void main(String[] args){
        Point a = new Point();
        Point b = new Point();
        a.setX(1);
        a.setY(2);
        b.setX(3);
        b.setY(4);
        System.out.println(a);
        System.out.println(b);
        operate dis = new operate();
        System.out.println(dis.distance(a, b));
    }
}


