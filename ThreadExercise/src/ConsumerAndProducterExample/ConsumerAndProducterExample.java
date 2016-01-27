package ConsumerAndProducterExample;

/**
 * Created by zhuxinquan on 16-1-27.
 */
public class ConsumerAndProducterExample {
    public static void main(String[] args) {
        Food f = new Food();
        Producter p = new Producter(f);
        Consumer c = new Consumer(f);
        new Thread(p).start();
        new Thread(c).start();
    }
}

//生产者:厨师
class Producter implements Runnable{

    private Food food;

    public Producter(Food food){
        this.food = food;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2 == 0){
                food.set("炒鸡蛋", "韭菜炒鸡蛋");
            }else{
                food.set("炒米饭", "韭菜鸡蛋炒米饭");
            }
        }
    }
}

//消费者：服务员
class Consumer implements Runnable{
    private Food food;

    public Consumer(Food food){
        this.food = food;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            food.get();
        }
    }
}


//产品：食物
class Food{
    private String name;
    private String desc;

    private boolean flag =  true; //true表示可以生产
                                  //false表示可以消费

    //生产产品
    public synchronized void set(String name, String desc){
        if(!flag){
            try {
                this.wait();        //线程处于等待状态，等待唤醒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setName(name);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setDesc(desc);
        flag = false; //表示可以进行消费
        this.notify();
    }
    //消费产品
    public synchronized void get(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + ":" + this.desc);
        flag = true; //表示可以生产
        this.notify();
    }

    public Food(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Food() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
