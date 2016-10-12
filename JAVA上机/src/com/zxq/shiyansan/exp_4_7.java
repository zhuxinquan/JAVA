package com.zxq.shiyansan;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by zhuxinquan on 16-10-11.
 */
public class exp_4_7 {
    public static void main(String [] args) throws Exception{
        String url = "http://www.baidu.com";  //自行输入URL，例如www.xupt.edu.cn;
        InputStream in = (new URL(url)).openStream();   //获得指定URL的字节输入流
        int c = -1;
        while((c = in.read()) != -1){       //按字节的方式输入数据和输出数据
            System.out.write(c);
        }
    }
}
