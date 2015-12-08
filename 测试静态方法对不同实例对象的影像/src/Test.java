/**
 * Created by zhuxinquan on 15-11-24.
 */

class Test1{
    int a = 1;



    public Test1(int a){
        this.a = a;
    }

    public static void setset(int b){
        //a = b;
    }
}

public class Test {
    public static void main(String[] args){
        Test1 obj1, obj2;
        obj1 = new Test1(2);
        obj2 = new Test1(3);
        System.out.println("obj1-before a:"+obj1.a);
        System.out.println("obj1-before a:"+obj2.a);
        Test1.setset(4);
        System.out.println("obj2-before a:"+obj1.a);
        System.out.println("obj2-before a:"+obj2.a);
    }
}
