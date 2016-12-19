package com.zxq.shiyanba;

import java.net.DatagramSocket;

/**
 * Created by zhuxinquan on 16-11-22.
 */
public class ScanThread implements Runnable{
    private PortCount pc;
    private String name = null;
    public ScanThread(String name, PortCount pc){
        this.name = name;
        this.pc = pc;
    }
    public void run(){//必需的重写
        int i = 0;
        DatagramSocket ds = null;
        while(true){
            try{
                i = pc.add();
                if(i > 100)break;
                ds = new DatagramSocket(i);
                System.err.println("本机端口:" + i + "空闲");
                Thread.sleep(100);
            }catch(Exception e){
                System.err.println(e.toString());
            }
        }
    }
}