package echo;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by zhuxinquan on 16-8-17.
 */
public class EchoClientDemo {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8000);
            Scanner in = new Scanner(System.in);
            System.out.println("The server address : " + socket.getInetAddress().getHostAddress());
            boolean flag = true;
            PrintStream ps = new PrintStream(
                    new BufferedOutputStream(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            while(flag){
                System.out.println("please input:");
                String info = in.next();
                if("exit".equals(info)){
                    flag = false;
                    ps.println(info);
                    ps.flush();
                }else{
                    ps.println(info);
                    ps.flush();
                    System.out.println(br.readLine());
                }
            }
            ps.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
