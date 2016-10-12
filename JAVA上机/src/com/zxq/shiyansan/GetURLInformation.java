package com.zxq.shiyansan;

import java.net.URL;
import java.net.MalformedURLException;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by zhuxinquan on 16-10-11.
 */
public class GetURLInformation extends Frame{
    TextField tUrl = new TextField("输入URL地址");
    List lItems = new List(20);
    Button bOk = new Button("解  析");
    Font f = new Font("Serif",Font.BOLD,30);
    public GetURLInformation(){
        this.setLayout(new BorderLayout());
        this.add(tUrl, BorderLayout.NORTH);
        this.add(lItems, BorderLayout.CENTER);
        this.add(bOk, BorderLayout.SOUTH);
        tUrl.setFont(f);
        lItems.setFont(f);
        bOk.setFont(f);
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
        GetURLInformation mainFrame = new GetURLInformation();
        mainFrame.setSize(400, 400);
        mainFrame.setTitle("解析URL");
        mainFrame.setVisible(true);
    }
    class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            URL getURL = null;

            try{
                getURL = new URL(tUrl.getText());
            }catch(MalformedURLException e1){
                System.out.println("URL解析错误" + e1);
            }
            lItems.add("Reference:" + getURL.getRef(), 0);
            lItems.add("File Name:" + getURL.getFile(), 0);
            lItems.add("File Path:" + getURL.getPath(), 0);
            lItems.add("Host Port:" + getURL.getPort(), 0);
            lItems.add("Host Name:" + getURL.getHost(), 0);
            lItems.add("Protocol :" + getURL.getProtocol(), 0);
        } }
}
