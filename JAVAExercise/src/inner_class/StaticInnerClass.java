package inner_class;

/**
 * Created by zhuxinquan on 16-7-21.
 * 一个静态内部类相当于外部类
 */
public class StaticInnerClass {
    public static void main(String[] args) {
        //静态内部类的声明如下，静态内部类可以当做外部类使用
        Outer2.Inner inner = new Outer2.Inner();
        inner.InnerGetName();
    }
}

class Outer2{
    private String name;

    public Outer2(String name) {
        this.name = name;
    }

    static class Inner{
        public void InnerGetName(){
            System.out.println("Static Inner Class");
        }
    }
}