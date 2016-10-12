package com.zxq.shiyansan;

/**
 * Created by zhuxinquan on 16-10-11.
 */

import java.io.*;
import java.net.*;

public class exp_4_8 {
    public static void main(String [] args){
        try{
            InputStream imageSource = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1476190713&di=e4f794c513d44bea8dd5f875cd000167&src=http://un.edulife.com.cn/upload/pic/201110/18011443398.jpg").openStream();
            FileOutputStream myFile = new FileOutputStream("./Logo.jpg");
            BufferedOutputStream myBuffer = new BufferedOutputStream(myFile);
            DataOutputStream myData = new DataOutputStream(myBuffer);
            int ch;
            while((ch = imageSource.read()) > -1){   //由网络输入数据
                myData.write(ch);                //将数据输出到文件中
            }
            myBuffer.flush();                     //将文件缓存中数据写入文件
            imageSource.close();
            myFile.close();
            myBuffer.close();
            myData.close();
        }catch(Exception e){
            System.err.print(e.toString());
        }
    }
}
