package Chapter7;

/**
 * Created by zhuxinquan on 15-12-3.
 */
public class Test {
    public static void main(String[] args) {
        char data[] = {'a', 'b', 'c', 'd', 'e'};
        StringBuffer buffer = new StringBuffer();
        buffer.insert(0, 100);
        buffer.insert(0, 2.5F);
        buffer.insert(3, '*');
        buffer.insert(0, 250.0);
        buffer.insert(5, "is equal to");
        System.out.println(buffer);
    }
}
