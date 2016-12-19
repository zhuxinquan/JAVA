package com.zxq.shiyanba;

/**
 * Created by zhuxinquan on 16-11-22.
 */
import java.net.*;
public class PortCount{ //共享资源，计数器count
    private int port;//共享资源
    synchronized public int add(){
        port = port + 1;
        return port;
    }
}

