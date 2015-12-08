package Chapter7;

import java.util.Arrays;

/**
 * Created by zhuxinquan on 15-12-3.
 */
public class Ex7_6 {
    public static void main(String[] args) {
        int[] intArr1 = {8, 18, 6, 36, 7,  47, 3, 58, 5, 66, 4, 74};
        int[] intArr2 = new int[12];
        System.arraycopy(intArr1, 0, intArr2, 0, 5);
        for(int i = 0; i < intArr2.length; i++){
            System.out.print(intArr2[i] + " ");
        }
        System.out.println();
        Arrays.sort(intArr1);
        for(int i = 0; i < intArr1.length; i++){
            System.out.print(intArr1[i] + " ");
        }
    }
}
