package set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by zhuxinquan on 16-7-23.
 * Set接口：
 * 1.不允许重复
 */
public class SetDemo {

    public static void treeset(){
        Set<String> set = new TreeSet<>();
        set.add("123");
        set.add("456");
        set.add("123");
        System.out.println(set);
        /**
         * 在Treeset集合中存放自定义对象时，该对象必须实现Comparable/Compartor接口
         * 同时利用该接口中的比较方法去除重复值（返回0表名重复，则不进行保存）
         */
        Set<User> set1 = new TreeSet<>();
        set1.add(new User("123", 13, "man"));
        set1.add(new User("234", 14, "femal"));
        set1.add(new User("111", 11, "man"));
        set1.add(new User("456", 14, "feman"));
        System.out.println(set1);
    }

    public static void hashset(){
        Set<String> set = new HashSet<String>();
        set.add("123");
        set.add("456");
        set.add("789");
        System.out.println(set.size());

//        Object[] objs = set.toArray();
        //toArray中的参数为一个类型（泛型），指示要返回的类型
        String[] names = set.toArray(new String[]{});
        for (String s : names){
            System.out.println(s);
        }

        Set<User> set1 = new HashSet<>();
        set1.add(new User("hujiahui", 18, "man"));
        set1.add(new User("hujiahui2", 18, "woamn"));
        set1.add(new User("hujiahui", 18, "man"));
        System.out.println(set1);
    }

    /**
     * LinkedHashSet实现类
     * 利用哈希表+双向链表实现
     * 输出会以插入的顺序输出
     * 底层使用LinkedHashMap实现
     */
    public static void Linkedhashset(){
        Set<User> set = new LinkedHashSet<>();
        set.add(new User("hujiahui", 18, "man"));
        set.add(new User("hujiahui2", 18, "woamn"));
        set.add(new User("hujiahui", 18, "man"));
        System.out.println(set);
    }

    public static void main(String[] args) {
//        hashset();
//        treeset();
        Linkedhashset();
    }
}
