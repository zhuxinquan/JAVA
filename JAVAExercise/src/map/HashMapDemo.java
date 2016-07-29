package map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuxinquan on 16-7-29.
 */
public class HashMapDemo {

    /**
     * HashMap实现类
     * 1.通过哈希表+链表实现
     * 2.通过key对象的hashCode方法模哈希表长度求出散列值
     *   根据散列值得出对象在哈希表中存储的位置
     * 3.当哈希表需要重新散列，会影响性能
     * @param args
     */
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "123");
        map.put(2, "234");
        map.put(3, "345");
        System.out.println(map);
    }
}
