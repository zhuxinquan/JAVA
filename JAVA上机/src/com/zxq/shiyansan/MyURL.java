package com.zxq.shiyansan;

import java.net.URL;

/**
 * Created by zhuxinquan on 16-10-11.
 */
public class MyURL {
    URL url;
    public MyURL(String urlStr){
        try{
            url = new URL(urlStr);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    public void resolve(){
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
        System.out.println(url.getFile());
        System.out.println(url.getQuery());
        System.out.println(url.getRef());
    }
    public static void main(String [] args){
        MyURL my =
                new MyURL("http://222.24.16.1:8080/home/index.jsp#new?key=java");
        my.resolve();
    }
}
