package inner_class;

/**
 * Created by zhuxinquan on 16-7-21.
 * 匿名内部类：
 * 1.不能有构造方法，只能有一个实例（即刚产生的对象）
 * 2.不能定义任何静态成员，静态方法
 * 3.不能是public，protected，private，static
 * 4.在new的后面，用其隐含实现一个接口或实现一个类
 * 5.匿名内部类为局部的，所以局部内部类的所有限制都对其生效
 */
public class AnonymityInnerClass {
    public static void main(String[] args) {

        //继承式匿名内部类，继承匿名内部类中重写了say()方法
        Outer3 outer3 = new Outer3("name") {
            public void say() {
                System.out.println("继承式匿名内部类");
            }
        };
        outer3.say();

        //接口式匿名内部类
        Child child = new Child() {
            @Override
            public void talk() {
                System.out.println("接口式匿名内部类");
            }
        };
        child.talk();

        //参数式匿名内部类
        childTalk(new Child() {
            @Override
            public void talk() {
                System.out.println("参数式匿名内部类");
            }
        });
    }

    public static void childTalk(Child c){
        c.talk();
    }
}

class Outer3{
    private String name;

    public Outer3(String name) {
        this.name = name;
    }

    public void say(){
        System.out.println("Outer3");
    }
}

interface Child{
    public void talk();
}