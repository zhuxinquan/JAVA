import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/**
 * Created by zhuxinquan on 16-1-17.
 */
public class OutputStreamWriter {
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
        writer();
    }
}
