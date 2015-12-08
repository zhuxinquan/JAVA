import java.awt.*;

/**
 * Created by zhuxinquan on 15-11-19.
 */
class Ex4 {
    static String corpName = "123";
    int i = 0;

    public void method(){
        System.out.println(i);
        System.out.println(corpName);
    }
}

class Ex4_11 {
    int i = 0;
    public static void main(String[] args){
        Ex4 obj = new Ex4();
        System.out.println(i);
        obj.method();
    }
}
