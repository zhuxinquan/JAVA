package echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhuxinquan on 16-8-17.
 */
public class EchoServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8000);
        boolean flag = true;
        while(flag){
            Socket socket = ss.accept();
            System.out.println("accept success\n");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintStream ps = new PrintStream(
                    new BufferedOutputStream(socket.getOutputStream()));
            boolean bool = true;
            while(bool){
                String info = br.readLine();
                if("".equals(info) || "exit".equals(info)){
                    bool = false;
                }else {
                    System.out.println(info);
                    ps.println("echo:" + info);
                    ps.flush();
                }
            }
            ps.close();
            br.close();
        }
    }
}
