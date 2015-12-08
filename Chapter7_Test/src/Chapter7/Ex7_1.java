package Chapter7;

/**
 * Created by zhuxinquan on 15-12-3.
 */
public class Ex7_1 {
    public static void main(String[] args) {
        int i;
        Integer[] f = new Integer[5];
        f[0] = f[1] = 1;
        for(i = 2; i < 5; i++)
        {
            f[i] = f[i-1] + f[i-2];
        }
        for(i = 0; i < 5; i++){
            System.out.println("f[" + i + "]=" + f[i]);
        }
    }
}
