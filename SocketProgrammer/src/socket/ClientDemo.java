package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by zhuxinquan on 16-8-17.
 */
public class ClientDemo {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("192.168.30.142", 8888);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            String info = br.readLine();
            System.out.println(info);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
