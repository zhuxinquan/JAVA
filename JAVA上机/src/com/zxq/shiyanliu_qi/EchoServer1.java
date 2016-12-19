package com.zxq.shiyanliu_qi;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhuxinquan on 16-11-15.
 */
public class EchoServer1 {

    private int port=8054;
    private ServerSocketChannel serverSocketChannel=null;
    private ExecutorService executorService;//线程池

    private static final int POOL_MULTIPLE=4;//线程池中工作线程的数组

    public EchoServer1() throws IOException {
//		创建一个线程池
        executorService= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_MULTIPLE);

        //创建一个ServerSocketChannel对象。
        //使得在同一个主机上关闭了服务器程序，紧接着再启动该服务器程序时，可以顺利绑定相同端口
        serverSocketChannel=ServerSocketChannel.open();

        //让服务器与一个本地端口绑定。
        serverSocketChannel.socket().bind(new InetSocketAddress(port));

        System.out.println("服务器启动");

    }

    public void service(){
        while(true){
            SocketChannel socketChannel=null;
            try {
//                System.out.println("1234");
                socketChannel=serverSocketChannel.accept();
//                System.out.println("134");
                executorService.execute(new Handler(socketChannel));

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) throws IOException {

        new EchoServer1().service();
    }
}
