import java.io.*;

/**
 * Created by zhuxinquan on 16-1-17.
 */
public class OutputStreamWriter {

    /**
     * 使用转换流，将字节流转换字符流
     */
    public static void reader(){
        try {
            InputStream in = new FileInputStream("./test.txt");
            Reader reader = new InputStreamReader(in);
            char[]  cs = new char[50];
            int len = -1;
            StringBuilder sb = new StringBuilder();
            try {
                while((len = reader.read(cs)) != -1){
                    sb.append(cs, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过字节转换输出流将字符串写入文件
     */
    public static void writer() throws IOException {
        OutputStream out = new FileOutputStream("./test.txt");
        String info = "test txt";
        Writer writer = new java.io.OutputStreamWriter(out);
        writer.write(info);
        writer.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        reader();
    }
}
