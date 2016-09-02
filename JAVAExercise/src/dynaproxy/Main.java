package dynaproxy;

import java.lang.reflect.Proxy;

/**
 * Created by zhuxinquan on 16-8-18.
 */
public class Main {
    public static void main(String[] args) {
        Person p = new Person("name");
        DynaProxy dynaProxy = new DynaProxy(p);

        //动态生成代理对象(类加载器， 被代理接口， InvocationHandler)
        Subject s = (Person)Proxy.newProxyInstance(p.getClass().getClassLoader(), p.getClass().getInterfaces(), dynaProxy);
        s.work();
    }
}
