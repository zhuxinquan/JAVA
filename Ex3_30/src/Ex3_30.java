import java.util.Scanner;

/**
 * Created by zhuxinquan on 15-11-18.
 */
public class Ex3_30 {
    public static void  main(String[] args){
        Scanner reader = new Scanner(System.in);
        int n = 0;
        double sum = 0.0, score;
        System.out.print("input:");
        while(reader.hasNext()){
            if(reader.hasNextDouble()){
                score = reader.nextDouble();
                sum += score;
                n++;
            }else{
                String str = reader.next();
                if(str.equalsIgnoreCase("ok")) break;
            }
        }
        System.out.println("平均分 = "+ sum/n);
    }
}
