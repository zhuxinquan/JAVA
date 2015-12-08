import java.awt.*;
import java.util.*;
/**
 * Created by zhuxinquan on 15-11-17.
 */
public class Ex3_8 {
    public static void main(String[] args){
        int a, b, c;
        Scanner reader = new Scanner(System.in);
        System.out.print("请输入两个整数：");
        a = reader.nextInt();
        b = reader.nextInt();
        GcdLcm o = new GcdLcm();
        c = o.getGcd(a, b);
        System.out.println("gcd("+a+","+b+")="+c);
        System.out.println("lcm("+a+","+b+")="+(a * b)/c);
    }
}

class GcdLcm{
    public int getGcd(int m, int n){
        int r;
        r = m%n;
        while(r != 0){
            m = n;
            n = r;
            r = m%n;
        }
        return n;
    }
}