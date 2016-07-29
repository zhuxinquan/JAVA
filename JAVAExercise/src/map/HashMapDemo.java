package map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zhuxinquan on 16-7-29.
 */
public class HashMapDemo {

    /**
     * TreeMap实现类
     * 1.使用红黑树实现
     * 2.以key对象的自然顺序构造映射树
     */
    public static void treeMap(){
        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "123");
        map.put(2, "234");
        map.put(3, "345");
        System.out.println(map.size());

        Map<Person, String> map2 = new TreeMap<>();
        map2.put(new Person("123", 12), "123");
        map2.put(new Person("234", 23), "234");
        System.out.println(map2.size());
    }

    /**
     * Hashtable实现类
     * 1.不允许键值为null
     * 2.用默认的初始容量 (11) 和加载因子 (0.75) 构造一个新的空哈希表
     * 3.线程安全的。同步
     */
    public static void hashTable(){
        Hashtable<String, String> table = new Hashtable<>();
        table.put("1", "123");
    }

    /**
     * HashMap实现类
     * 1.通过哈希表+链表实现
     * 2.通过key对象的hashCode方法模哈希表长度求出散列值
     *   根据散列值得出对象在哈希表中存储的位置
     * 3.当哈希表需要重新散列，会影响性能
     * 4.线程不安全
     * @param args
     */
    public static void main(String[] args) {
//        Map<Integer, String> map = new HashMap<>();
//        map.put(1, "123");
//        map.put(2, "234");
//        map.put(3, "345");
//        System.out.println(map);
        treeMap();
    }
}
