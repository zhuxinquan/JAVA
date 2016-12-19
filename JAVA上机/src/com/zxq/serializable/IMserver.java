package com.zxq.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhuxinquan on 16-12-19.
 */
public class IMserver implements Cloneable, Runnable {
    ServerSocket service = null;
    Socket clientSocket = null;
    ObjectInputStream ois = null;
    Thread worker = null;

    public static void main(String [] argv)throws IOException {
        IMserver serv = new IMserver();
        serv.startServer();
    }
    public synchronized void startServer() throws IOException{
        if(worker == null){
            service = new ServerSocket(8080);
            System.out.println("Server Listen on 8080!");
            worker = new Thread(this);
            worker.start();
        }
    }
    public void run(){
        Socket client = null;
        if(service != null){
            while(true){
                try{
                    client = service.accept();
                    IMserver newServer = (IMserver)clone();  //注意启动通信线程的方法
                    newServer.service = null;
                    newServer.clientSocket = client;
                    newServer.worker = new Thread(newServer);
                    newServer.worker.start();
                }catch(IOException e){
                    e.printStackTrace();
                }catch(CloneNotSupportedException e){
                    e.printStackTrace();
                }
            }
        }else{
            perform(clientSocket);
        }
    }
    private void perform(Socket client){
        try{
            ois = new ObjectInputStream(clientSocket.getInputStream());
            int i = 10;
            Message obj = null;
            while(i-- > 0){
                obj = (Message) ois.readObject();
                System.out.println(obj.toString());  //注意该语句输出是什么内容
                System.out.println(obj.sender + " " + obj.action + " " + obj.receiver + " : " + obj.context);
                System.out.printf("---------------");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            ois.close();
            clientSocket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
