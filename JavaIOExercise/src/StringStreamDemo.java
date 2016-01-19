import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by zhuxinquan on 16-1-19.
 */
public class StringStreamDemo {

    public static void StringStream() throws IOException {
        //写入操作
        StringWriter sw = new StringWriter();
        sw.write(97);
        sw.write("test,StringWriter!");

        //读取操作,由一个字符串构造一个字符串输入流
        StringReader sr = new StringReader(sw.toString());

        char[] cs = new char[10];
        int num = sr.read();
        System.out.println(num);
        int len = -1;
        try {
            while((len = sr.read(cs)) != -1){
                System.out.print(new String(cs, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        StringStream();
    }
}
