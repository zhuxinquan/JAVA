package reflection;

import java.lang.reflect.*;

/**
 * 反射机制
 * Created by zhuxinquan on 16-8-18.
 */
public class RefDemo {
    public static void main(String[] args) {
        Person p1 = new Person("name1", 12, 'm');
        Person p2 = new Person("name2", 13, 'f');

        //一个Class对象代表一份字节码，相同类型的对象得到的字节码对象是同一个

        //1
        Class personClass = p1.getClass();
        Class personClass2 = p2.getClass();

        System.out.println(personClass == personClass2);

        //2
        Class personClass3 = Person.class;
        System.out.println(personClass3 == personClass2);

        //3
        Class personClass4 = null;
        try {
            personClass4 = Class.forName("reflection.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(personClass3 == personClass4);

        //通过类信息实例化对象
        //无参构造
        try {
            //调用此方法，若类中没有无参构造方法，就会报异常
            Person p3 = (Person) personClass.newInstance();
            System.out.println(p3);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //有参构造
        Constructor[] cs = personClass.getConstructors();
//        for(Constructor c:cs){
//            System.out.println(c.getName());
//            Class[] paramsTypes =  c.getParameterTypes();
//            for(Class class1 : paramsTypes){
//                System.out.println(class1);
//            }
//        }
        Person p4 = null;
        try {
            //获取指定类型的构造方法
            Constructor c1 = personClass.getConstructor(String.class, int.class, char.class);
            p4 = (Person) c1.newInstance("name111", 13, 'w');
            System.out.println(p4);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //返回所有的公有方法
        Method[] m1 = personClass.getMethods();
        for (int i = 0; i < m1.length; i++) {
            Method m = m1[i];
            System.out.println(m.getName());
        }
        System.out.println("----------");
        //返回所有的是个声明的方法，不包括继承的
        Method[] m2 = personClass.getDeclaredMethods();
        for (int i = 0; i < m2.length; i++) {
            Method m = m1[i];
            System.out.println(Modifier.toString(m.getModifiers()) + " : " + m.getName());
        }

        //返回公有字段
        Field[] fs = personClass.getFields();
        for (int i = 0; i < fs.length; i++) {
            System.out.println(fs[i].getName());
        }


        System.out.println("---调用方法---");
        try {
            Method setNameMethod = personClass4.getMethod("setName", String.class);
            setNameMethod.invoke(p4, "setName");
            System.out.println(p4);
            Method satMethod = personClass4.getDeclaredMethod("say");
            satMethod.setAccessible(true);
            satMethod.invoke(p4);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        System.out.println("---调用属性---------");
        try {
            Field ageField = personClass.getDeclaredField("age");
            ageField.setAccessible(true);//忽略检查访问修饰符
            System.out.println(ageField.get(p1));
            ageField.set(p1, 15);
            System.out.println(p1);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
