package com.zxq.shiyansi.QA1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhuxinquan on 16-11-6.
 */
public class Server {
    public static void main(String[] args) {
        try {
            String user = "admin";
            String passwd = "passwd";
            String string1 = null;
            String string2 = null;
            int len = 0;
            byte[] b = new byte[1024];

            ServerSocket serverSocket = new ServerSocket(8888);
            Socket client = serverSocket.accept();
            System.out.println("客户端已链接");


            PrintStream printStream = new PrintStream(new BufferedOutputStream(client.getOutputStream()));
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(client.getInputStream()));

            printStream.print("请输入用户名：");
            printStream.flush();

            len = dataInputStream.read(b);
            string1 = new String(b, 0, len);

            printStream.print("请输入密码：");
            printStream.flush();
            len = dataInputStream.read(b);
            string2 = new String(b, 0, len);

            if(string1.trim().equals("admin") && string2.trim().equals("passwd")){
                printStream.print("登陆成功！");
                printStream.flush();
            }else{
                printStream.print("登陆失败！");
                printStream.flush();
            }
            printStream.flush();
            printStream.close();
            dataInputStream.close();
            client.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
