package com.zxq.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

/**
 * Created by zhuxinquan on 16-12-18.
 */
public class Server implements Cloneable, Runnable {
    ServerSocket service = null;
    Socket clientSocket = null;
    ObjectInputStream ois = null;
    Thread worker = null;
    KeyPairGenerator kgen;
    KeyPair kpair;
    public static void main(String [] argv)throws IOException {
        Server serv = new Server();
        serv.startServer();
    }
    public synchronized void startServer() throws IOException{
        if(worker == null){
            service = new ServerSocket(8888);
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
                    Server newServer = (Server)clone();
                    newServer.service = null;
                    newServer.clientSocket = client;
                    newServer.worker = new Thread(newServer);
                    newServer.worker.start();
                }catch(IOException e){
                    System.err.println(e.getMessage());
                }catch(CloneNotSupportedException e){
                    System.err.println(e.getMessage());
                }
            }
        }else{
            perform(clientSocket);
        }
    }
    private void perform(Socket client){
        try{
            ois = new ObjectInputStream(clientSocket.getInputStream());
            SignedObj obj = (SignedObj)ois.readObject();
            Signature sig = Signature.getInstance("SHA/DSA");
            sig.initVerify(obj.pub);
            sig.update(obj.b);
            boolean valid = sig.verify(obj.sig);
            if(valid){
                System.out.println("签名有效");
            }else{
                System.out.println("签名无效");
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        try{
            ois.close();
            clientSocket.close();
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}
