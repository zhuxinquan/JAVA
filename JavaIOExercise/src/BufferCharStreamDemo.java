import java.io.*;

/**
 * Created by zhuxinquan on 16-1-17.
 */
public class BufferCharStreamDemo {

    /**
     * 使用缓冲流实现读取操作
     * @throws IOException
     */
    public static void reader() throws IOException {
        Reader r = new FileReader("./test.txt");
        BufferedReader br = new BufferedReader(r);
        char[] ch = new char[2];
        int len = -1;
        StringBuilder sb = new StringBuilder();
        while((len = br.read(ch)) != -1){
            sb.append(new String(ch, 0, len));
        }
        System.out.println(sb);
        br.close();
        r.close();
    }

    /**
     * 使用字符缓冲流实现文件写入操作
     */
    public static void write(){
        try {
            Writer w = new FileWriter("./test.txt", true);
            BufferedWriter bw = new BufferedWriter(w);
            bw.write("test BufferedWriter");
            bw.close();
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
//        write();
        reader();
    }
}
