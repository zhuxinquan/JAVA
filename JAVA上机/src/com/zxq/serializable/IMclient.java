package com.zxq.serializable;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by zhuxinquan on 16-12-19.
 */
public class IMclient {
    public static void main(String [] argv){
        Socket s = null;
        ObjectOutputStream os = null;
//        try{
//            s = new Socket("localhost", 8080);
//            os = new ObjectOutputStream(s.getOutputStream());
//            Message obj = new Message("LiMing", "ZhangHua", "kick", "Come on");
//            os.writeObject(obj);
//            os.flush();
//            System.out.println("Message Send Successful");
//            os.close();
//            s.close();
//        }
        try{
            s = new Socket("localhost", 8080);
            os = new ObjectOutputStream(s.getOutputStream());
            Message obj = null;
            int i = 10;
            while(i-- > 0) {
                obj = new Message("LiMing", "ZhangHua", "kick", "Come on");
                os.writeObject(obj);
                os.flush();
                System.out.println("Message Send Successful");
            }
            os.close();
            s.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
