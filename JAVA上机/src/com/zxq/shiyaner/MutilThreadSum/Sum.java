package com.zxq.shiyaner.MutilThreadSum;

/**
 * Created by zhuxinquan on 16-9-27.
 */
public class Sum {
    private int count;//共享资源
    public int add(){
        synchronized(this){ //代码段1，共享锁，修饰程序段或者方法
            count = count + 1;
            System.out.println("add:" + count);
            return count;
        }
    }
}
