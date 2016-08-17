package udp;

import java.io.IOException;
import java.net.*;

/**
 * UDP发送端
 * Created by zhuxinquan on 16-8-17.
 */
public class UDPserverDemo {
    public static void main(String[] args) {
        String info = "test info";
        byte[] bytes = info.getBytes();
        try {
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName("127.0.0.1"), 8000);
            DatagramSocket datagramSocket = new DatagramSocket(3000);
            datagramSocket.send(datagramPacket);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
