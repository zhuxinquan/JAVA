package com.zxq.shiyaner.mutil_thread_add_sub;

/**
 * Created by zhuxinquan on 16-9-28.
 */
public class AddSubMutiThreadTest{
    public static void main(String[] args) {
        Count count = new Count();
        SubThread subThread = new SubThread(count);
        AddThread addThread = new AddThread(count);
        Thread s1 = new Thread(subThread);
        Thread s2 = new Thread(subThread);
        Thread s3 = new Thread(subThread);
        Thread s4 = new Thread(subThread);

        Thread a1 = new Thread(addThread);
        Thread a2 = new Thread(addThread);
        Thread a3 = new Thread(addThread);
        Thread a4 = new Thread(addThread);

        s1.setPriority(10);
        a1.setPriority(10);
        s2.setPriority(1);
        a2.setPriority(1);

        s1.setName("减线程-1");
        s1.setName("减线程-2");
        s1.setName("减线程-3");
        s1.setName("减线程-4");

        a1.setName("加线程-1");
        a1.setName("加线程-2");
        a1.setName("加线程-3");
        a1.setName("加线程-4");

        s1.start();
        s2.start();
        s3.start();
        s4.start();

        a1.start();
        a2.start();
        a3.start();
        a4.start();

        try {
            s1.join();
            s2.join();
            s3.join();
            s4.join();

            a1.join();
            a2.join();
            a3.join();
            a4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("final:" + count.getCount());
    }
}
