package Chapter8;

/**
 * Created by zhuxinquan on 15-12-6.
 */
public class Ex8_1 {
    static void method(){
        int x = 0, z = 10;
        int y = 10 / x;
        System.out.println("z = " + z);
    }
    public static void main(String[] args){
        method();
        System.out.println("After method.");
    }
}
