package com.zxq.shiyansi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhuxinquan on 16-10-18.
 */
public class SimpleServer {

    //位置一
    public static void main(String [] args){
        //TCP通信，作为服务器
  //位置二
        ServerSocket serverSocket = null;
        //首先建立服务器
        try{//端口号唯一标是本进程
            //位置三

            serverSocket = new ServerSocket(10000); //修改10为本地TCP已被占用的端口，或超过0－65535的端口，观察结果
            System.out.println("Server is Listening on Port 10 Now");
        }catch(IOException e){
            System.err.println("Can't listen on port 10000");
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
            //输出操作
            out.println("Welcome to My Chat Server");
            out.flush();//立即将数据从输出缓存提交给网络发送
            //接收键盘输入
            DataInputStream stdIn =  new DataInputStream(System.in);
            //输入操作
            while((inputLine = in.readLine()) != null){ //接受网络数据
                System.out.println("Customer:" + inputLine);
                System.out.print("Server:");
                outputLine = stdIn.readLine();  //接受键盘输入
                //System.out.println("Server:" + outputLine);
                out.println(outputLine); //向网络发送数据
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
