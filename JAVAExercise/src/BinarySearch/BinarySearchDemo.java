package BinarySearch;

import java.util.Arrays;

/**
 * Created by zhuxinquan on 16-5-31.
 * 二分查找，必须保证数列有序
 */
public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] numbers = {3, 54, 5, 7, 34, 32};
        Arrays.sort(numbers);

        int index = binarySearch(numbers, 54);
        System.out.println(index);
    }

    private static int binarySearch(int[] x, int n){
        int start = 0;
        int end = x.length - 1;
        int middle = -1;
        while(start <= end){
            middle = (start + end) / 2;
            if(x[middle] == n){
                return middle;
            }else if(x[middle] < n){
                start = middle + 1;
            }else if(x[middle] > n){
                end = middle - 1;
            }
        }
        return -1;
    }
}
