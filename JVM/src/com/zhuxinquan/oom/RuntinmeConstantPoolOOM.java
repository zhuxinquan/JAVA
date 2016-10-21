package com.zhuxinquan.oom;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuxinquan on 16-10-17.
 * 运行时常量池导致的内存溢出异常
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class RuntinmeConstantPoolOOM {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
//        int i = 0;
//        while(true){
//            list.add(String.valueOf(i++).intern());
//        }
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ma").append("in").toString();
        System.out.println(str2.intern() == str2);
    }
}
