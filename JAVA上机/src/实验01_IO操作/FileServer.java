package 实验01_IO操作;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhuxinquan on 16-9-18.
 */
public class FileServer {
    public static void main(String[] args) {
        File file = new File("./1.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ServerSocket serverSocket = new ServerSocket(10086);
            Socket client = serverSocket.accept();

            //创建网络输出流并提供数据包装器
            OutputStream netOut=client.getOutputStream();
            OutputStream doc=new DataOutputStream(new
                    BufferedOutputStream(netOut));

            //创建文件读取缓冲区
            byte[] buf=new byte[2048];
            int num = fileInputStream.read(buf);
            while(num!=(-1)){           //是否读完文件
                doc.write(buf, 0, num);      //把文件数据写出网络缓冲区
                doc.flush();              //刷新缓冲区把数据写往客户端
                num=fileInputStream.read(buf);        //继续从文件中读取数据
            }
            fileInputStream.close();
            doc.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
