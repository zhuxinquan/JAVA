package com.zxq.shiyanba;

import java.io.*;       //引入IO类库
import java.net.*;      //引入网络类库

/**
 * Created by zhuxinquan on 16-11-22.
 */
class exp_6_2  implements Runnable{
    DatagramSocket ds = null;	//新建一个DatagramSocket实例
    DatagramPacket p = null;
    InetAddress address = null;
    int  port = 0;
    byte [] buf = new byte[256];  //开辟接收数据缓冲区，256 B
    public exp_6_2 (){
        try{
            ds = new DatagramSocket(1080);		//开启本地UDP 1080端口
            System.out.println("本地开启UDP 1080端口");
        }catch(IOException e){
            System.err.println(e.toString());
        } }
    public void run(){
        try{
            p = new DatagramPacket(buf, buf.length);
            ds.receive(p);
            System.out.println("接收的数据：" + new String(p.getData()));
            Thread.sleep(2000);
            address = p.getAddress();
            port = p.getPort();
            System.out.println("请求端Socket" + address.toString() + ":" + port);
            buf = "从A端返回信息".getBytes();
            p = new DatagramPacket(buf, buf.length, address, port);
            ds.send(p);
            ds.close();
        }catch(Exception e){
            System.err.println();
        } }
    public static void main(String args[ ]){
        exp_6_2 dr = new exp_6_2 ();
        Thread tdr = new Thread(dr);
        tdr.start();
    } }