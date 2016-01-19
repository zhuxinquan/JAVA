import java.io.*;

/**
 * Created by zhuxinquan on 16-1-18.
 */
public class DataStreamDemo {

    public static void reader(){
        try {
            InputStream in = new FileInputStream("./test.txt");
            DataInputStream dis = new DataInputStream(in);
            int flag = dis.readInt();
            String info = dis.readUTF();
            String info2 = dis.readUTF();
            dis.close();
            in.close();
            System.out.println("flag = " + flag + ", info = " + info + ", info2 = " + info2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入数据流
     */
    public static void write(){
        try {
            OutputStream out = new FileOutputStream("./test.txt");
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeInt(97);
            dos.writeUTF("test, 数据流");
            //写入时，每两个UTF字符间会有分隔符自动进行区分
            dos.writeUTF("test2, 数据流2");
            dos.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        write();
        reader();
    }
}
