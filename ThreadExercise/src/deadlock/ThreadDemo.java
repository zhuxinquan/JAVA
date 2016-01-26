package deadlock;

/**
 * 多线程共享数据的安全问题，使用同步解决
 * 1.同步代码块
 * 2.同步方法
 * Created by zhuxinquan on 16-1-26.
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread my = new MyThread();
        Thread t1 = new Thread(my, "t1");
        Thread t2 = new Thread(my, "t2");

        t1.start();
        t2.start();

    }
}

class MyThread implements Runnable{

    Object obj = new Object();      //同步的标记对象

    @Override
    public void run() {
//        同步代码块
        synchronized (obj){
//            System.out.println(Thread.currentThread().getName() + "start");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "success");
            doMethod();
        }
    }

    /**
     * 同步方法，同步的标记对象为当前对象
     * 若有两个同步方法，调用一个方法后，另一个方法不能再被调用
     */
    public synchronized void doMethod(){
        System.out.println(Thread.currentThread().getName() + "start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "success");
    }
}
