package com.zxq.shiyansi.QA1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;


/**
 * Created by zhuxinquan on 16-11-6.
 */
public class Client {
    public static void main(String[] args) {
        try {
            byte[] b = new byte[1024];
            int len = 0;
            String string = null;
            Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
            DataInputStream in = new DataInputStream(System.in);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());


            len = dataInputStream.read(b);
            string = new String(b, 0, len);
            System.out.print(string);
            dataOutputStream.write(in.readLine().getBytes());
            dataOutputStream.flush();

            len = dataInputStream.read(b);
            string = new String(b, 0, len);
            System.out.print(string);
            dataOutputStream.write(in.readLine().getBytes());
            dataOutputStream.flush();

            len = dataInputStream.read(b);
            string = new String(b, 0, len);
            System.out.print(string);

            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
