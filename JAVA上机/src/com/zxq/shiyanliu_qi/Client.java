package com.zxq.shiyanliu_qi;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by zhuxinquan on 16-11-15.
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("127.0.0.1", 8054);
            InputStream inputStream = client.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            OutputStream outputStream = client.getOutputStream();
//            outputStream.write("1234".getBytes());
//            outputStream.flush();
            byte[] bytes = new byte[1024];
            String string = null;
            DataInputStream dataInputStream1 = new DataInputStream(System.in);
            while(!(string = dataInputStream1.readLine()).equals("bye")){
//                System.out.println(string);
                outputStream.write((string + "\n").getBytes());
                outputStream.flush();
                System.out.println(dataInputStream.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
