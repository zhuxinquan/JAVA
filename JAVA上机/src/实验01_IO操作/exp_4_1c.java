package 实验01_IO操作;

/**
 * Created by zhuxinquan on 2016-09-17.
 */
import java.lang.String;
import java.util.Scanner;
public class exp_4_1c{
    public static void main(String args[]){
        System.out.println("请输入若干个数,每输入一个数用回车确认");
        System.out.println("最后输入一个非数字结束输入操作");
        Scanner reader = new Scanner(System.in);
        double sum=0;
        int m=0;
        while(reader.hasNextDouble()){
            double x = reader.nextDouble();
            m=m+1;
            sum=sum+x;
        }
        System.out.println(m + "个数的和为" + sum);
        System.out.println(m + "个数的平均值是" + sum/m);
    }
}