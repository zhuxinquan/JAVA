package deadlock;

/**
 * 以顾客和服务生对峙举例死锁
 * Created by zhuxinquan on 16-1-26.
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        new DeadThread();
    }
}

//顾客
class Customer {
    public synchronized void say(Waiter w){
        System.out.println("先服务");
        w.doService();
    }
    public synchronized void doService(){
        System.out.println("同意先收钱");
    }
}
//服务生
class Waiter {
    public synchronized void say(Customer c){
        System.out.println("先收钱");
        c.doService();
    }
    public synchronized void doService(){
        System.out.println("同意先服务");
    }
}


class DeadThread implements Runnable{
    Customer c = new Customer();
    Waiter w = new Waiter();

    //在构造方法中创建线程并启动，两个同步方法相互等待对方执行完毕产生死锁
    public DeadThread(){
        new Thread(this).start();
        w.say(c);
    }
    @Override
    public void run() {
        c.say(w);
    }
}
