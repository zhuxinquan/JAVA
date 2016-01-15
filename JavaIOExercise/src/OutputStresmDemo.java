import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by zhuxinquan on 16-1-15.
 */
public class OutputStresmDemo {

    public static void write1(){
        try{
            OutputStream out = new FileOutputStream("./test.txt");
            String info = "hello IO";
            byte[] bytes = info.getBytes();
            for(int i = 0; i < info.length(); i++){
                out.write(bytes[i]);        //一个一个将字节写入字节输出流并写入文件
            }
            out.write(bytes);       //将一个字节数组一次性的写入输出流并写入文件当中
            out.write(97);          //将一个字节数（ascii值）转换为字符输出到文件输出流并写入文件中
            out.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        write1();
    }
}
