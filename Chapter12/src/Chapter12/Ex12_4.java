package Chapter12;

import java.io.IOException;

/**
 * Created by zhuxinquan on 15-12-9.
 */
public class Ex12_4 {
    public static void main(String[] args) {
        int count = 0, i;
        boolean first = true;
        System.out.print("please input:");
        try{
            while((i = System.in.read()) != '\n'){
                if(first){
                    System.out.print("received：");
                    first = false;
                }
                count++;
                System.out.print((char)i);
            }
        }catch (IOException e){
            System.out.println("occurred IOException");
        }
        System.out.println("\ncount = " +  count);
    }
}