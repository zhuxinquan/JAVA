package 实验01_IO操作;

/**
 * Created by zhuxinquan on 2016-09-17.
 */
import java.io.*;
class exp_4_1a{
    public static void main(String [] args){
        try{
            int c1 = System.in.read();
            System.out.println("c1 = " + c1);
            char c2 = (char)c1;
            System.out.println("c2 = " + c2);
            char c3 = (char)System.in.read();
            System.out.println("c3 = " + c3);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}