package com.zxq.shiyaner.MutilThreadSum;

/**
 * Created by zhuxinquan on 16-9-27.
 */
public class SumThread implements Runnable {
    private Sum sd;
    private int sum = 0;
    private	int [] a = new int[100];
    private String name;

    public SumThread(String name, Sum sd){
//        super(name);
//        Thread.currentThread().setName(name);
        this.name = name;
        this.sd = sd;
    }
    public void run(){//必需的重写
        Thread.currentThread().setName(name);
        try{
            for(int i=0;i<100;i++){
                a[i] = sd.add();
                sum += a[i];
                Thread.sleep(10);
            }
            Thread.sleep(1000);
        }catch(Exception e){}

        System.out.println(Thread.currentThread().getName() + " 累加和:" + sum);
    }
    public void showData(){
        System.out.print(getName() + " 获得的数为 ");
        for(int i=0;i<100;i++){
//            if(i%10==0)System.out.println();
            System.out.print(a[i] + "+  ");
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSum(){
        return sum;
    }
}
