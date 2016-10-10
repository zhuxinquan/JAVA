package design_pattern.singletonPattern;

import java.io.Serializable;

/**
 * Created by zhuxinquan on 16-10-10.
 */
public class Singleton implements Serializable{
    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static Singleton instance = null;

    /* 私有构造方法，防止被实例化 */
    private Singleton() {
    }

    /* 静态工程方法，创建实例 */
    public static Singleton getInstance() {
        /**
         * 多线程使用时，只有在第一次创建对象的时候需要加锁，之后就不需要了
         */
        synchronized (instance) {
            if (instance == null) {
                instance = new Singleton();
            }
        }
        return instance;

    }

    public Object readResolve() {
        return instance;
    }
}
