package com.zxq.shiyaner.mutil_thread_add_sub;

/**
 * Created by zhuxinquan on 16-9-27.
 */
public class Count {
    public int getCount() {
        return count;
    }

    private int count = 0;

    public void add(){
        synchronized (this){
            count ++;
            System.out.println("+1");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void sub(){
        synchronized (this){
            count --;
            System.out.println("-1");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
