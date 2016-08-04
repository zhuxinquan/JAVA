package map;

import java.util.*;

/**
 * Created by zhuxinquan on 16-7-29.
 */
public class HashMapDemo {

    /**
     * Map接口的输出
     * 1.使用map.keySet()方法把key对象转换成set集合，迭代set集合取出每个value
     * 2.使用map.values()方法将所有的value对象转换成Collection集合，然后进行迭代
     * 3.使用map.entryset()方法把所有的entry对象转换成set集合，然后进行迭代
     */
    public static void print(){
        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "123");
        map.put(2, "234");
        map.put(3, "345");
        System.out.println(map.size());

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iter2 = entries.iterator();
        while(iter2.hasNext()){
            Map.Entry<Integer, String> entry = iter2.next();
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }
    }

    /**
     * LinkedHashMap具有可预知的迭代顺序
     */
    public static void linkedHashMap(){

    }

    /**
     * TreeMap实现类
     * 1.使用红黑树实现
     * 2.以key对象的自然顺序构造映射树
     * 3.使用自定义对象作为key值时，该对象的类必须实现Comparable/Comparator接口实现比较规则
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
//        treeMap();
        print();
    }
}
