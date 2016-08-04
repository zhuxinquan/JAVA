package map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhuxinquan on 16-8-1.
 * 使用HashMap模拟通讯录，实现CRUD
 */
public class HashMapDemo2 {
    public static void main(String[] args) {
        Contacts cs = new Contacts();
        cs.add(new Contact("fjdk", "123"));
        cs.add(new Contact("ds", "345"));
        Map<Integer, Contact> maps = cs.getConacts();
        Set<Integer> keyset = maps.keySet();
        Iterator<Integer> iters = keyset.iterator();
        while(iters.hasNext()){
            Integer key = iters.next();
            System.out.println(maps.get(key));
         }
    }
}
