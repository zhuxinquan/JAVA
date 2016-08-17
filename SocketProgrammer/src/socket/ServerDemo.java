package socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhuxinquan on 16-8-17.
 */
public class ServerDemo {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8888);
            //等待客户端连接，阻塞
            Socket s = server.accept();
            String info = "test socket\n";
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(s.getOutputStream()));
            bw.write(info);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
