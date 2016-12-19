package com.zxq.shiyanba;

/**
 * Created by zhuxinquan on 16-11-22.
 */
public class ScanLocalUDPPort{
    public static void main(String [] args) throws Exception{
        PortCount pc = new PortCount();//代表共享资源的变量
        ScanThread st1 = new ScanThread("线程1",pc);   //创建子线程
        ScanThread st2 = new ScanThread("线程2",pc);
        ScanThread st3 = new ScanThread("线程3",pc);
        Thread tst1 = new Thread(st1);
        Thread tst2 = new Thread(st2);
        Thread tst3 = new Thread(st3);
        long begin = System.currentTimeMillis();
        tst1.start();	tst2.start();	tst3.start();
        tst1.join(); 	tst2.join(); 	tst3.join();
        long end = System.currentTimeMillis();
        System.out.println("探测localhost的TCP端口，共耗时" + (end - begin)+"毫秒");
    }
}