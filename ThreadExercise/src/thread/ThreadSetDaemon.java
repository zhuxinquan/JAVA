package thread;

/**
 * setDaemon
 * 设置守护线程
 * 当用户线程退出后，若剩余的全部为守护线程，则java虚拟机退出，程序运行结束
 * yield:暂停当前正在执行的线程对象，并执行其他线程
 * Created by zhuxinquan on 16-1-26.
 */
public class ThreadSetDaemon {
    public static void main(String[] args) throws InterruptedException {
        Daemon daemon = new Daemon();
        Thread t = new Thread(daemon);
//        t.setDaemon(true);
//        System.out.println(t.isDaemon());
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main-" + i);
            if(i == 5){
                //让出！！当次！！cpu执行时间
                Thread.yield();
            }
            Thread.sleep(1000);
        }
    }
}

class Daemon implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("Daemon-" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
