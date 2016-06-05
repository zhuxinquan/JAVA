package ObjectClone;

/**
 * Created by zhuxinquan on 16-6-2.
 */
public class Test {
    public static void main(String[] args) {
        Cat c = new Cat("hello", 3);
        System.out.println("c = " + c);
        try {
            Cat b = (Cat)c.clone();
            System.out.println("b = " + b);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
