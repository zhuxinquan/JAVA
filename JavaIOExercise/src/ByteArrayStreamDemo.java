import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by zhuxinquan on 16-1-18.
 */
public class ByteArrayStreamDemo {

    /**
     * 使用ByteArrayOutputStream实现写操作
     * @throws IOException
     */
    public static void write() throws IOException {
        //创建一个字节数组输出流对象
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String info = "test ByteArrayOutputStream!!";
        //往缓冲区输出数据
        baos.write(info.getBytes());
        baos.write(97);         //int值ascii转换为对应字符
        baos.close();           //关闭无效

        //根据字节数组构造字节数组输入流
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        byte[] bytes = new byte[10];
        int len = -1;
        StringBuilder sb = new StringBuilder();
        while((len = bais.read(bytes)) != -1){
            sb.append(new String(bytes, 0, len));
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        write();
    }
}
