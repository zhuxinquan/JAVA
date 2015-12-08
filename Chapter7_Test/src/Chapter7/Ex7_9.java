package Chapter7;

/**
 * Created by zhuxinquan on 15-12-3.
 */
public class Ex7_9 {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer("Java");
        StringBuffer s2 = new StringBuffer("HTML");
        s1.append(" is fun");
        System.out.println(s1);
        s1.append(s2);
        System.out.println(s1);
        s1.insert(2, " is fun");
        System.out.println(s1);
        s1.insert(1, s2);
        System.out.println(s1);
        s1.deleteCharAt(3);
        System.out.println(s1);
        s1.delete(1, 3);
        System.out.println(s1);
        s1.replace(1, 3, "computer");
        System.out.println(s1);
    }
}
