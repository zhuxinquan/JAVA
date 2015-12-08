package Chapter8;

/**
 * Created by zhuxinquan on 15-12-7.
 */
public class Test {
    public static void main(String[] args) {
        try{
            System.exit(1);
            int i = 10/0;
        }
        finally {
            System.out.println("finally处理");
        }
    }
}
