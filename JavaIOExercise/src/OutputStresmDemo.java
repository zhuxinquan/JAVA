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
                out.write(bytes[i]);
            }
            out.write(bytes);
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
