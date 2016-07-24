package set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhuxinquan on 16-7-23.
 * Set接口：
 * 1.不允许重复【
 */
public class SetDemo {

    public static void hashset(){
        Set<String> set = new HashSet<String>();
        set.add("123");
        set.add("456");
        set.add("789");
        System.out.println(set.size());
    }

    public static void main(String[] args) {
        hashset();
    }
}
