package com.zxq.shiyansi;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by zhuxinquan on 16-10-18.
 */
public class ScanPort {
    public static void main(String args[]) throws IOException {
        Socket comSocket = null;

        for(int i=0;i<1024; i++){
            try{
                //建立socket连接
                comSocket = new Socket("localhost", i);//发出连接请求

                System.out.println("Can get I/O for the Connection, Port:" + i);
            }catch(UnknownHostException e){
//                System.err.println("Can't find the Server host");
                //System.exit(0);
            }catch(IOException e){
//                System.err.println("Can't get I/O for the Connection, Port:" + i);
                //System.exit(0);
            }
        }

        try{
            comSocket.close();
        }catch(Exception e){}
    }
}
