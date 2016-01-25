package thread;

/**
 * intertupt()方法只是设置了线程的中断状态，并没有真正的中断线程
 * 当设置中断标记后调用wait， sleep方法会产生中断异常
 * Created by zhuxinquan on 16-1-25.
 */
public class ThreadInterruptDemo {
    public static void main(String[] args) {
        MyThreadInterrupt my = new MyThreadInterrupt();
        Thread t1 = new Thread(my);
        t1.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main-" + i);
            if (i == 5){
                t1.interrupt();     //中断线程（进行设置中断标记）
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThreadInterrupt implements Runnable{
    @Override
    public void run() {
        int i = 0;
        while(!Thread.interrupted()) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                //当线程抛出异常时，中断标记被清楚，在catch中再次设置
                Thread.currentThread().interrupt();
            }
        }
    }
}
