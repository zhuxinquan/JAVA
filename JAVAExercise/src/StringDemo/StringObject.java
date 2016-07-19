package StringDemo;

/**
 * 字符串编译期与运行期分析
 * Created by zhuxinquan on 16-7-19.
 */
public class StringObject {
    public static void main(String[] args) {
        //
        String a = "a1";
        String a1 = "a" + 1;
        System.out.println(a == a1);

        //
        String b = "b1";
        int bb = 1;
        String b1 = "b" + bb;
        System.out.println(b == b1);

        //
        String c = "c1";
        final int cc = 1;
        String c1 = "c" + cc;
        System.out.println(c == c1);

        //
        String d = "d1";
        final int dd = getDd();
        String d1 = "d" + dd;
        System.out.println(d == d1);
    }

    public static int getDd(){
        return 1;
    }
}
