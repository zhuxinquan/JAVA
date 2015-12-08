package Chapter8;

/**
 * Created by zhuxinquan on 15-12-6.
 */
public class Ex8_2 {
    static void method(){
        int x = 0, z = 10;
        try{
            int y = 10 / x;
            System.out.println("z = " + z);
        }catch(ArithmeticException e){
            System.out.println("ArithmeticException");
        }
        System.out.println("After try/catch blocks.");
    }
    public static void main(String[] args){
        method();
        System.out.println("After method.");
    }
}
