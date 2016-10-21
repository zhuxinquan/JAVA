package stop.thread;

/**
 * Created by zhuxinquan on 16-10-19.
 */
public class WrongWayStopThread extends Thread {
    public static void main(String[] args) {
        WrongWayStopThread thread = new WrongWayStopThread();
        System.out.println("start thread...");
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("interruptering thread...");
        thread.interrupt();

        System.out.println("stop application...");
    }

    @Override
    public void run() {
//        while(Thread.currentThread().isInterrupted()){
        while(true){
            System.out.println("thread is running...");
//            long time = System.currentTimeMillis();
//            while(System.currentTimeMillis() - time < 1000){
//                //空循环1秒
//            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
