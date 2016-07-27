package iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhuxinquan on 16-7-26.
 */
public class IteratorDemo {

    public static void iterator(Collection<String> c){
        Iterator<String> iter = c.iterator();
        while(iter.hasNext()){
            String s = iter.next();
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        List list = new ArrayList<String>();
        list.add("123");
        list.add("234");
        list.add("345");
        iterator(list);
    }
}
