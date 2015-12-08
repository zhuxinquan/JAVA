import java.util.Scanner;

/**
 * Created by zhuxinquan on 15-11-23.
 */
public class calc {
    public static void main(String[] args) {
        System.out.println("input expression");
        String s;
        Scanner in = new Scanner(System.in);
        s = in.next();
        Expression exp = new Expression(s);
    }
}

class Expression{
    Expression(){}
    Expression(String s){
        char ch = '+';
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int a = s.charAt(i) - 48;
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                        a = a * 10 + s.charAt(j) - 48;
                        i++;
                    }else{
                        break;
                    }
                }
                switch (ch) {
                    case '+':
                        result += a;
                        break;
                    case '-':
                        result -= a;
                        break;

                }
            }
            if(++i >= s.length()){          //在末尾未输入等号时,表达式完成直接输出结果
                System.out.println(result);
                break;
            }else{
                --i;
            }
            ch = s.charAt(++i);
            if(ch == '='){                  //在表达式末尾遇到等号时，直接输出结果
                System.out.println(result);
            }
        }
    }
}
