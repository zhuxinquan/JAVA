package com.zxq.shiyansi;

import java.net.Socket;
import java.util.Date;

/**
 * Created by zhuxinquan on 16-10-18.
 */
public class myJava {
    public static void main(String [] args){
        long start = (long) new Date().getTime();
        String host = "222.24.16.";
        String host_ip = null;
        Socket cs = null;
        for(int i=1; i<17; i++){
            host_ip = host + i;
            for(int j=0; j<1000; j++){
                try{
                    cs = new Socket(host_ip, j);
                    System.out.println(host_ip + " : " + j);
                }catch(Exception e){
//                    System.out.println(host_ip + "拒绝连接");
//                    e.printStackTrace();
                }
            }
        }
        long end = new Date().getTime();
        System.out.println("消耗时间：" + (end - start));
    }
}
