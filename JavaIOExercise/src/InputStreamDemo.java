import jdk.internal.org.objectweb.asm.tree.analysis.SourceInterpreter;
import jdk.internal.util.xml.impl.Input;

import java.io.*;

/**
 * Created by zhuxinquan on 16-1-15.
 */
public class InputStreamDemo {

    //一次性读取所有的字节
    public static void read1() throws IOException {
        File f = new File("test.txt");
        InputStream in = new FileInputStream(f);
        //根据文件大小构造字符数组
        byte[] bytes = new byte[(int)f.length()];       //通过使用f.length获取到该文件总共有多少字节
        int len = in.read(bytes);
        System.out.println(new String(bytes));
        in.close();
    }

    //每次读取一个字节
    public static void read2() throws IOException {
        InputStream in = new FileInputStream("./test.txt");
        int b = -1;
        //in.read的返回值为int类型
        while((b = in.read()) != -1){
            System.out.print((char)b);
        }
        in.close();
    }

    //每次获取指定长度个字节
    public static void read3() throws IOException {
        InputStream in = new FileInputStream("./test.txt");
        byte[] bytes = new byte[10];
        int len = -1;   //存储每次读取的实际长度
        StringBuilder sb = new StringBuilder();
        while((len = in.read(bytes)) != -1){
            System.out.println(new String(bytes, 0, len) + " "  + "len = " + len);
            sb.append(new String(bytes, 0, len));
        }
        System.out.println(sb);
        in.close();
    }
    public static void main(String[] args) throws IOException {
        read3();
    }
}
