package com.zxq.shiyansi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhuxinquan on 16-10-18.
 */
public class MyServer {
    public static void main(String [] args){
        //TCP通信，作为服务器
        ServerSocket serverSocket = null;
        //首先建立服务器
        try{
            serverSocket = new ServerSocket(10000);
            System.out.println("Server is Listening Now");
        }catch(IOException e){
            System.err.println("Can't listen on port");
            System.exit(1);
        }
        //接受客户端连接
        Socket clientSocket = null;
        try{
            clientSocket = serverSocket.accept(); //connect
        }catch(IOException e){
            System.err.println("Accept failed");
            System.exit(1);
        }
        try{
            PrintStream out = new PrintStream(
                    new BufferedOutputStream(clientSocket.getOutputStream(), 1024) ,false);
            DataInputStream in = new DataInputStream(
                    new BufferedInputStream(clientSocket.getInputStream()));

            String inputLine, outputLine;
            //自定义协议
            MyProtocol greeting = new MyProtocol();
            outputLine = greeting.processInput(null);
            //输出操作
            out.println("Welcome to My Chat Server");
            out.flush();//立即将数据从输出缓存提交给网络发送
            //输入操作
            while((inputLine = in.readLine()) != null){
                System.out.println(outputLine);
                //协议处理信息
                outputLine = greeting.processInput(inputLine);
                out.println(outputLine);
                out.flush();
                if(outputLine.equals("bye")) break;
            }
            out.close();//流关闭
            in.close();
            clientSocket.close();//套接字关闭
            serverSocket.close();
        }catch(IOException e){
            System.err.println("Protocol Stream Error");
        }
    }
}
