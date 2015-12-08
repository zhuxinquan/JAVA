package Chapter7;

import java.util.StringTokenizer;

/**
 * Created by zhuxinquan on 15-12-4.
 */
public class Ex7_10 {
    public static void main(String[] args) {
        String str = "this is a test";
        StringTokenizer st = new StringTokenizer(str);
        System.out.println(str + "共有" + st.countTokens() + "个单词。它们是：");
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}
