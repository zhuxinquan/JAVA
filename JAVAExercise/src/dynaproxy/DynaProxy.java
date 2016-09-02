package dynaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类
 * Created by zhuxinquan on 16-8-18.
 */
public class DynaProxy implements InvocationHandler {

    //被代理对象
    private Object target;

    public DynaProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        //正在调用业务方法
        before();
        object =  method.invoke(target, args);
        after();
        return object;
    }

    public void after(){
        System.out.println("after");
    }

    public void before(){
        System.out.println("before");
    }

}
