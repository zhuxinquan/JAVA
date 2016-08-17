package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP接收端
 * Created by zhuxinquan on 16-8-17.
 */
public class UDPClientDemo {
    public static void main(String[] args) {
        try {
            byte[] bytes = new byte[1024];
            //构造一个接收时使用的数据报
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            //构造一个指定端口UDP的socket对象
            DatagramSocket datagramSocket = new DatagramSocket(8000);
            datagramSocket.receive(datagramPacket);
            String info = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println(info);
            datagramSocket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
