package list;

import java.util.ArrayList;
import java.util.Vector;

/**
 * List接口 允许重复值 空值  必须有序
 * Created by zhuxinquan on 16-2-9.
 */
public class ListDemo {

    public static void vector(){
        Vector vector = new Vector();
        vector.add("test");
        System.out.println(vector);
    }

    /**
     * ArrayList实现类
     */
    public static void arrayList(){
        vector();
//        ArrayList list = new ArrayList();
//        list.add(1);
//        list.add("+");
//        list.add(1);
//        list.add("=");
//        list.add(2);
//        list.add(3, "123");
//
//        System.out.println(list);
//        System.out.println(list.get(3));
//        System.out.println(list.indexOf(1));
    }

    public static void main(String[] args) {
        arrayList();
    }
}
