package com.zhuxinquan.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by zhuxinquan on 16-10-17.
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeFiekd = Unsafe.class.getDeclaredFields()[0];
        unsafeFiekd.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeFiekd.get(null);
        while(true){
            unsafe.allocateMemory(_1MB);
        }
    }
}