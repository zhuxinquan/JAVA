package design_pattern.proxy_pattern;

/**
 * Created by zhuxinquan on 16-7-20.
 * 静态代理模式：为其它对象提供一种代理以控制对这个对象的访问
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Person p = new Person("name");
        ProxyClass px = new ProxyClass(p);
        px.work();
    }
}

//公共主题接口
interface Subject{
    public void work();
}

//被代理类
class Person implements Subject{
    private String name;

    @Override
    public void work() {
        System.out.println(name + " work in……");
    }

    public Person(String name){
        this.name = name;
    }
}

//代理类
class ProxyClass implements Subject {

    private Subject target;

    public ProxyClass(Subject target) {
        this.target = target;
    }

    public void after(){
        System.out.println("after");
    }

    public void before(){
        System.out.println("before");
    }

    @Override
    public void work() {
        before();
        target.work();
        after();
    }
}