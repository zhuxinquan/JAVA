package hashCode;

import java.util.HashSet;

/**
 * Created by zhuxinquan on 16-8-17.
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet();
        Person p1 = new Person("123", 12);
        Person p2 = new Person("234", 23);

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p1.hashCode()%16);
        System.out.println(p2.hashCode()%16);

        set.add(p1);
        set.add(p2);
    }
}
