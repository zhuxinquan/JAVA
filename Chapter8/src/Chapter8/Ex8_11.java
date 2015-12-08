package Chapter8;

/**
 * Created by zhuxinquan on 15-12-7.
 */
public class Ex8_11 {
    public static void main(String[] args) {
        try{
            int a = args.length;
            System.out.println("a = " + a);
            int b = 42 / a;
            int[] c = {1};
            c[4] = 99;          //引发数组越界异常

        }catch (ArithmeticException e){
            System.out.println(e);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        System.out.println("After try/catch blocks.");
    }
}
