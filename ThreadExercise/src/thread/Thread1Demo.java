package thread;

/**
 * Created by zhuxinquan on 16-1-25.
 */
public class Thread1Demo {
    public static void main(String[] args) {
        System.out.println("获取当前线程的名字：" + Thread.currentThread().getName());
        Mythread1 my = new Mythread1();
        Thread t1 = new Thread(my, "xiancheng1");
        Thread t2 = new Thread(my, "xiancheng2");
        System.out.println(t1.getId());
//        设置线程名
//        t1.setName("xiancheng1");
        System.out.println("t1线程alive:" + t1.isAlive());
        t1.start();
        t2.start();
        //测试线程是否处于活动状态
        System.out.println("t1线程alive:" + t1.isAlive());
    }
}

class Mythread1 implements Runnable{

    @Override
    public void run() {
        System.out.println("获取当前线程的名字：" + Thread.currentThread().getName());
    }
}