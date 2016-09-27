package com.zxq.shiyaner;

/**
 * Created by zhuxinquan on 16-9-27.
 */
public class SumDemo {
    public static void main(String [] args){
        Sum sd = new Sum();//代表共享资源的变量
        SumThread s1 = new SumThread("线程1",sd);//创建完毕
        SumThread s2 = new SumThread("线程2",sd);
        SumThread s3 = new SumThread("线程3",sd);
        Thread st1 = new Thread(s1);
        Thread st2 = new Thread(s2);
        Thread st3 = new Thread(s3);
        st1.setPriority(Thread.MAX_PRIORITY);  //代码段2
//        st2.setPriority(10);
        st3.setPriority(1);
        long begin = System.currentTimeMillis();
        st1.start();//使线程运行
        st2.start();
        st3.start();
        try {
            st1.join();
            st2.join();
            st3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        s1.showData();
        s2.showData();
        s3.showData();
        System.out.println("\n总和为:" + (s1.getSum() + s2.getSum() + s3.getSum()));
        long end = System.currentTimeMillis();
        System.out.println("探测localhost的TCP端口，共耗时" + ( end - begin)+"毫秒");
    }
}
