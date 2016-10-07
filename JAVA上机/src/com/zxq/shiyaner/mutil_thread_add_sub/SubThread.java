package com.zxq.shiyaner.mutil_thread_add_sub;

/**
 * Created by zhuxinquan on 16-9-28.
 */
public class SubThread implements Runnable {

    private Count count;

    public SubThread(Count count) {
        this.count = count;
    }

    public void run() {
        count.sub();
    }
}
