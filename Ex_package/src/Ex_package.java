/**
 * Created by zhuxinquan on 15-11-20.
 */
package chapter4;
import static chapter4.StaticImportee.*;

public class Ex_package {
    public static void main(String[] args){
        System.out.println(one);
        System.out.println(TWO);
        System.out.println(three());
        System.out.println(new Four().value());
    }
}

