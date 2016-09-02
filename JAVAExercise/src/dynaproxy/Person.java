package dynaproxy;

/**
 * 被代理类
 * Created by zhuxinquan on 16-8-18.
 */
public class Person implements Subject{
    private String name;

    @Override
    public void work() {
        System.out.println(name + " work in……");
    }

    public Person(String name){
        this.name = name;
    }
}
