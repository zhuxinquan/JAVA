package thread;

import java.util.Date;

/**
 * 多线程的实现方式
 * 1.继承Thread类
 * 2.实现Runnable接口
 * Created by zhuxinquan on 16-1-24.
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        //使用自定义线程
        Mythread myThread = new Mythread();
        //启动线程
        myThread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main");
            Thread.sleep(10);
            if( i == 4){
                //主线程等待myThread线程执行结束，也指定等待的时间
                myThread.join();
            }
        }
//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread2 = new Thread(myRunnable);
//        thread2.start();
    }
}

//自定义线程类1
class Mythread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Date() + "-" + i);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//自定义线程类2
//为了方便继承其他的类，一般使用第二种实现接口的方式创建线程
class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("MyRunnable" + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}