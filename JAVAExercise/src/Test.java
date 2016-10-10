/**
 * Created by zhuxinquan on 16-10-10.
 */
class Mythread extends Thread{
    private static int count = 0;
    private static boolean flag = true;
    public synchronized void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " " + flag);
            if (!flag)
                try{
                    wait();
                }catch (InterruptedException e){}
            flag = false;
            System.out.println(getName() + " " + flag);
            count = count + 1;
            System.out.println(getName()+" count="+count);
            flag = true;
            notifyAll();
            try{
                sleep(20);
            }catch(InterruptedException e){}
        }
    }
    public Mythread(String name){
        super(name);
    }
}
public class Test {
    public static void main(String args[]){
        Mythread A = new Mythread("A");
        Mythread B = new Mythread("B");
        Mythread C = new Mythread("C");

        A.start();
        B.start();
        C.start();

        try {
            A.join();
            B.join();
            C.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread end.");
    }
}