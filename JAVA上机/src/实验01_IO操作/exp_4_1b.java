package 实验01_IO操作;

/**
 * Created by zhuxinquan on 2016-09-17.
 */
import java.io.*;
class exp_4_1b{
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("输入一个整数:");
        String str = br.readLine();
        int i = Integer.parseInt(str);
        System.out.print("输入一个实数:");
        str = br.readLine();
        float f = Float.parseFloat(str);
        System.out.println("它们的和是" + ( i + f));
    }
}