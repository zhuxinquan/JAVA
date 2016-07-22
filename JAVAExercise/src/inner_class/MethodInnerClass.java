package inner_class;

/**
 * Created by zhuxinquan on 16-7-21.
 */
public class MethodInnerClass {
    public static void main(String[] args) {
        Outer1 outer1 = new Outer1("name");
        System.out.println(outer1.getName());
    }
}

class Outer1{
    private String name;

    public Outer1(String name) {
        this.name = name;
    }

    //方法内部类
    //方法内部类只能在定义该内部类的方法内实例化，不可以在方法外对其实例化
    //方法内部类对象不能使用该内部类所在方法的非final局部变量
    public String getName(){
        //jdk1.8中当有方法内部类对象访问了所在方法的非final局部变量时，
        //该变量就会默认成为final变量，不可再次进行修改
        int x = 10;
        //内部类能独立的继承一个实现，使得多重继承的解决方案变得完整
        class Inner extends A{
            public String InnerGetName(){
                System.out.println(x);
                //非法的修改final变量
                //x = 20;
                return name;
            }
        }
        Inner inner = new Inner();
        return inner.InnerGetName();
    }
}

class A{
    public String  A;
}