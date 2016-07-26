package set;

import java.util.HashSet;
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

    public static void main(String[] args) {
//        hashset();
        treeset();
    }
}
