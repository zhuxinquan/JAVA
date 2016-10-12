#Java中的23种设计模式

创建型模式，共五种：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式。

结构型模式，共七种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。

行为型模式，共十一种：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。

其实还有两类：并发型模式和线程池模式。

##工厂方法模式

###普通工厂模式

建立一个工厂类，对实现了同一接口的一些类进行实例的创建，然后在使用时根据传入工厂类参数的不同返回对应的实例对象

###多工厂方法模式

普通工厂模式中根据传入的字符串参数返回不同的对象实例，若传递的字符串出错则不能正确创建对象，所以该模式在工厂类中使用了多个工厂方法创建实例对象

###静态工厂方法模式

与多工厂方法模式的区别就是将多工厂方法中的方法置为静态，工厂也不需要创建实例，直接使用

##抽象工厂模式

工厂方法的缺点在于只能根据创建工厂方法中存在的方法来创建类，如果要进行扩展，必须修改工厂类，所以这里用到了抽象工厂模式

抽象工厂模式包含一个统一的接口、实现该接口的实现类、工厂的接口、工厂的实现类，如果想要新增加功能，需要做一个功能实现类，实现统一的功能接口，然后再做一个工厂类，实现工厂接口

##单例模式

单例模式能保证在一个JVM中，某一个对象只有一个实例存在

在多线程环境下，单例模式的创建有可能导致并非只有单个对象，如果考虑到同步，也并非需要对整个单例模式的方法进行同步，其实只是在第一个对象创建的时候进行同步即可，防止多个线程同时创建了第一个对象

在Java指令中创建对象和赋值操作是分开进行的，也就是说instance = new Singleton();语句是分两步执行的。但是JVM并不保证这两个操作的先后顺序，也就是说有可能JVM会为新的Singleton实例分配空间，然后直接赋值给instance成员，然后再去初始化这个Singleton实例。这样就可能出错了，我们以A、B两个线程为例：

a>A、B线程同时进入了第一个if判断

b>A首先进入synchronized块，由于instance为null，所以它执行instance = new Singleton();

c>由于JVM内部的优化机制，JVM先画出了一些分配给Singleton实例的空白内存，并赋值给instance成员（注意此时JVM没有开始初始化这个实例），然后A离开了synchronized块。

d>B进入synchronized块，由于instance此时不是null，因此它马上离开了synchronized块并将结果返回给调用该方法的程序。

e>此时B线程打算使用Singleton实例，却发现它没有被初始化，于是错误发生了。

通过如下使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的，这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕

```
private static class SingletonFactory{
    private static class SingletonFactory{           
        private static Singleton instance = new Singleton();           
    }           
    public static Singleton getInstance(){           
        return SingletonFactory.instance;           
    }   
}
```

上述中有关单例模式的缺点存在于创建类的时候需要同步，所以只要将创建和getInstance()分开，单独同步也可以：

```
public class SingletonTest {  
  
    private static SingletonTest instance = null;  
  
    private SingletonTest() {  
    }  
  
    private static synchronized void syncInit() {  
        if (instance == null) {  
            instance = new SingletonTest();  
        }  
    }  
  
    public static SingletonTest getInstance() {  
        if (instance == null) {  
            syncInit();  
        }  
        return instance;  
    }  
} 
```

##建造者模式

建造者模式则是将各种产品集中起来进行管理，用来创建复合对象，所谓复合对象就是指某个类具有不同的属性

