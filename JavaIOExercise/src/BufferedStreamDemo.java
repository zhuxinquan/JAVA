import java.io.*;
import java.nio.Buffer;

/**
 * Created by zhuxinquan on 16-1-17.
 */
public class BufferedStreamDemo {
    /**
     * 通过输出缓冲流输出数据到文件
     * @throws FileNotFoundException
     */
    public static void write() throws FileNotFoundException {
        OutputStream out = new FileOutputStream("./test.txt");
        BufferedOutputStream bos = new BufferedOutputStream(out);
        String info = "test BufferedOutputStream!";
        try {
            bos.write(info.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用字节输出缓冲流读入文件
     */
    public static void read() throws IOException {
        InputStream out = new FileInputStream("./test.txt");
        BufferedInputStream bis = new BufferedInputStream(out);
        char[] cs = new char[5];
        Reader r = new InputStreamReader(bis);
        int len = -1;
        StringBuilder sb = new StringBuilder();
        while((len = r.read(cs)) != -1){
            sb.append(cs, 0, len);
        }
        System.out.println(sb);
        bis.close();
        out.close();
        r.close();
    }

    public static void main(String[] args) throws IOException {
//        write();
        read();
    }
}
