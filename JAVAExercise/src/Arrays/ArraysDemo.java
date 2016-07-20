package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zhuxinquan on 16-5-31.
 */
public class ArraysDemo {
    public static void main(String[] args) {
        String[] name = new String[6];
        //fill方法将填充所有的元素
        Arrays.fill(name, "hello");
        for (String s:name) {
            System.out.println(s);
        }

        //sort方法,只能从小到大排序
        int[] numbers = {1, 6, 23, 6};
        Arrays.sort(numbers);
        String[] s = {"sfds", "dfsf", "rt", "ert"};
        Arrays.sort(s);
        for (int n: numbers) {
            System.out.println(n);
        }
        //输出数组
        System.out.println(Arrays.toString(s));
        //复制数组到一个新的数组中
        int[] n = Arrays.copyOf(numbers, 3);
        System.out.println(Arrays.toString(n));

        //复制指定范围
        String[] s1 = Arrays.copyOfRange(s, 0, 3);
        System.out.println(Arrays.toString(s1));

        //二分查找，返回位置下标（0开始）
        for (int i:numbers ) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(Arrays.binarySearch(numbers, 6));


    }
}
