package list;

import java.util.ArrayList;

/**
 * List接口 允许重复值 空值  必须有序
 * Created by zhuxinquan on 16-2-9.
 */
public class ListDemo {

    /**
     * ArrayList实现类
     */
    public static void arrayList(){
        ArrayList list = new ArrayList();
        list.add(1);
        list.add("+");
        list.add(1);
        list.add("=");
        list.add(2);
        list.add(3, "123");

        System.out.println(list);
        System.out.println(list.get(3));
        System.out.println(list.indexOf(1));
    }

    public static void main(String[] args) {
        arrayList();
    }
}
