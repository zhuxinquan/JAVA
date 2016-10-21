package com.zxq.shiyansi;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by zhuxinquan on 16-10-18.
 */
public class MyClient {
    public static void main(String args[]) throws IOException {
        Socket comSocket = null;
        PrintStream out = null;
        DataInputStream in = null;
        try{
            //建立socket连接
            comSocket = new Socket("localhost", 10000);//相指定服务器的端口发出连接请求，注意服务器开放的TCP端口号
            //分别对应服务器端的O/I流
            in = new DataInputStream(comSocket.getInputStream());
            out = new PrintStream(comSocket.getOutputStream());
        }catch(UnknownHostException e){
            System.err.println("Can't find the Server host");
            System.exit(0);
        }catch(IOException e){
            System.err.println("Can't get I/O for the Connection");
            System.exit(0);
        }

        DataInputStream stdIn = new DataInputStream(System.in);
        String fromServer, fromUser;

        while((fromServer = in.readLine()) != null){
            System.out.println("Server:" + fromServer);
            if(fromServer.equals("bye")) break;
            fromUser = stdIn.readLine();
            if(fromUser != null){
                System.out.println("Client:" + fromUser);
                out.println(fromUser);
            }
        }
        out.close();
        in.close();
        stdIn.close();
        comSocket.close();
    }
}
