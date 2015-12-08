import java.util.Scanner;

/**
 * Created by zhuxinquan on 15-11-18.
 */
public class Ex3_27 {
    public static void main(String[] args){
        int n;
        Scanner reader = new Scanner(System.in);
        System.out.print("input :");
        n = reader.nextInt();
        new Tr().printMagic(n);
    }
}

class Tr{
    public void printMagic(int n){
        int t2 = 0, t = 1, t3;
        int i, j, s;
        for(i = 1; i <= n; i++){
            t += t2;
            s = t;
            for(j = i + 1, t3 = 0; t3 < n + 1 -i; j++, t3++){
                System.out.print(s+"   ");
                s += j;
            }
            System.out.println();
            t2++;
        }
    }
}
