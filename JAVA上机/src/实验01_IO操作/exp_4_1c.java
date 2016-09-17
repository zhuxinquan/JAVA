package 实验01_IO操作;

/**
 * Created by zhuxinquan on 2016-09-17.
 */
import java.lang.String;
import java.util.Scanner;
public class exp_4_1c{
    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        System.out.println("请输入若干个数,每输入一个数用回车确认");
        System.out.println("最后输入一个非数字结束输入操作");

        double sum=0;
        int m=0;
        while(reader.hasNextDouble()){
            double x = reader.nextDouble();
            m=m+1;
            sum=sum+x;
        }
//        System.out.println("%d个数的和为%f/n",m,sum);
//        System.out.println("%d个数的平均值是%f/n",m,sum/m);
    }
}