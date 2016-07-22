package inner_class;

/**
 * Created by zhuxinquan on 16-7-21.
 */
public class InnerDemo1 {
    public static void main(String[] args) {
        Outer outer = new Outer("outer");

        //成员内部类通过外部实例化的对象来实例化内部类（一般不使用）
        Outer.Inner inner = outer.new Inner();
        System.out.println(inner.getName());

        System.out.println(outer.InnerGetName());
    }
}

class Outer{
    private String name;

    public Outer(String name) {
        this.name = name;
    }

    //成员内部类
    class Inner{
        public String getName(){
            return name;
        }
    }

    //在本类方法中直接声明内部类，可直接使用
    public String InnerGetName(){
        Inner inner = new Inner();
        return inner.getName();
    }
}
