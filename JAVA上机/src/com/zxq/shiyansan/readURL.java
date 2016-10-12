package com.zxq.shiyansan;

/**
 * Created by zhuxinquan on 16-10-11.
 */
import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.awt.*;
import java.awt.event.*;

public class readURL extends Frame {
    TextField tUrl = new TextField("输入URL地址");
    List lItems = new List(20);
    Button bOk = new Button("下  载");
    Font f = new Font("Serif",Font.BOLD,30);
    public readURL(){
        this.setLayout(new BorderLayout());
        this.add(tUrl, BorderLayout.NORTH);
        this.add(lItems, BorderLayout.CENTER);
        this.add(bOk, BorderLayout.SOUTH);
        tUrl.setFont(f);
        lItems.setFont(f);
        bOk.setFont(f);
        //内部类
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
        bOk.addActionListener(new Listener());
    }
    public static void main(String args[]){
        System.out.println("Starting New...");
        readURL mainFrame = new readURL();
        mainFrame.setSize(400, 400);
        mainFrame.setTitle("下载URL");
        mainFrame.setVisible(true);
    }
    class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            URL getURL = null;
            InputStream in = null;
            try{
                getURL = new URL(tUrl.getText());
                in = getURL.openStream();
                DataInputStream buffer = new DataInputStream(in);
//                InputStreamReader buffer = new InputStreamReader(in, "UTF-8");
                String lineOfData, value;
                int i=0;
                while((lineOfData = buffer.readLine()) != null){
                    value = new String(lineOfData.getBytes("utf-8"),"utf-8");
//                    lItems.add((++i)+":"+lineOfData);
                    lItems.add((++i)+":"+value);   //注意这两句注释语句的作用
                }
            }catch(MalformedURLException e1){
                System.out.println("URL解析错误" + e1);
            }catch(IOException e2){
                System.out.println("IO错误" + e2);
            }finally{
                if( in != null){
                    try{
                        in.close();
                        lItems.add("下载完成");
                    }catch(IOException e3){
                    }
                }
            }
        }
    }
}
