package singletonPattern;

/**
 * Created by zhuxinquan on 16-7-19.
 * 单例设计模式：
 * 1.构造方法私有化
 * 2.声明一个本类对象
 * 3.给外部提供一个静态方法获取对象的实例
 */
public class SingletonDemo {
    public static void main(String[] args) {
        Singleton1 s = Singleton1.getInstance();
        s.print();
        Singleton1 s1 = Singleton1.getInstance();
        System.out.println(s == s1);
        Singleton2 s2 = Singleton2.getInstance();
        s2.print();
    }
}


class Singleton1{

    private static Singleton1 s = new Singleton1();

    private Singleton1(){}

    public void print(){
        System.out.println("饿汉-单例设计模式");
    }

    public static Singleton1 getInstance(){
        return s;
    }
}



class Singleton2{

    private static Singleton2 s = null;

    private Singleton2(){}

    public void print(){
        System.out.println("懒汉-单例设计模式");
    }

    public static Singleton2 getInstance(){
        if(s == null){
            s = new Singleton2();
        }
        return s;
    }
}
