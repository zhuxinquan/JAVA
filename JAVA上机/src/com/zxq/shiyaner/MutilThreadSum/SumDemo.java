package com.zxq.shiyaner.MutilThreadSum;

/**
 * Created by zhuxinquan on 16-9-27.
 * 1～10000的连加
 */
public class SumDemo {
    public static void main(String [] args){
        int allSum = 0;
        Sum sd = new Sum();//代表共享资源的变量
        long begin = System.currentTimeMillis();
        SumThread s = null;
        Thread st = null;
        for(int i = 0; i < 100; i++){
            s = new SumThread("线程" + i, sd);
            st = new Thread(s);
            st.start();
            try {
                if(i == 99){
                    st.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            allSum += s.getSum();
        }
//        SumThread s1 = new SumThread("线程1",sd);//创建完毕
//        SumThread s2 = new SumThread("线程2",sd);
//        SumThread s3 = new SumThread("线程3",sd);
//        SumThread s4 = new SumThread("线程4",sd);
//        SumThread s5 = new SumThread("线程5",sd);
//        SumThread s6 = new SumThread("线程6",sd);
//        SumThread s7 = new SumThread("线程7",sd);
//        SumThread s8 = new SumThread("线程8",sd);
//        SumThread s9 = new SumThread("线程9",sd);
//        SumThread s10 = new SumThread("线程10",sd);
//        Thread st1 = new Thread(s1);
//        Thread st2 = new Thread(s2);
//        Thread st3 = new Thread(s3);
//        Thread st4 = new Thread(s4);
//        Thread st5 = new Thread(s5);
//        Thread st6 = new Thread(s6);
//        Thread st7 = new Thread(s7);
//        Thread st8 = new Thread(s8);
//        Thread st9 = new Thread(s9);
//        Thread st10 = new Thread(s10);
//        st1.setPriority(1);  //代码段2
//        st2.setPriority(5);
//        st3.setPriority(10);
//        st1.start();//使线程运行
//        st2.start();
//        st3.start();
//        st4.start();
//        st5.start();
//        st6.start();
//        st7.start();
//        st8.start();
//        st9.start();
//        st10.start();
//        try {
//            st1.join();
//            st2.join();
//            st3.join();
//            st4.join();
//            st5.join();
//            st6.join();
//            st7.join();
//            st8.join();
//            st9.join();
//            st10.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        s1.showData();
//        s2.showData();
//        s3.showData();
//        s4.showData();
//        s5.showData();
//        s6.showData();
//        s7.showData();
//        s8.showData();
//        s9.showData();
//        s10.showData();
        System.out.println("\n总和为：" + allSum);
//        System.out.println("\n总和为:" + (s1.getSum() + s2.getSum() + s3.getSum() + s4.getSum() + s5.getSum() ));
//        System.out.println("\n总和为:" + (s1.getSum() + s2.getSum() + s3.getSum() + s4.getSum() + s5.getSum() + s6.getSum() + s7.getSum() + s8.getSum() + s9.getSum() + s10.getSum()));
        long end = System.currentTimeMillis();
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("探测localhost的TCP端口，共耗时" + ( end - begin)+"毫秒");
    }
}
