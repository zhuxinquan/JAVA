package Chapter12;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by zhuxinquan on 15-12-15.
 */
public class DataOutPutStreamEx12_15 {
    public static void main(String[] args) {
        try{
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Ex12_15.dat")));
            out.writeInt(100);
            out.writeDouble(3.1415926);
            out.writeBoolean(true);
            out.writeChar('A');
            out.writeUTF("DataOutPutStream类write()方法的使用");
            out.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
