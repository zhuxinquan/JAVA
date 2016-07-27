package iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by zhuxinquan on 16-7-26.
 */
public class ListIteratorDemo {

    /**
     * 使用ListIterator迭代器遍历集合
     */
    public static void listIterator(List<String> list){
        ListIterator<String> listIterator = list.listIterator();
        while(listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("789");
        listIterator(list);
    }
}
