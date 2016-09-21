package 实验六_IO流;

/**
 * Created by zhuxinquan on 16-9-20.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("./src/实验六_IO流/CopyFile.java");
            FileOutputStream fos = new FileOutputStream("temp.java");
            byte[] bytes = new byte[50];
            int len = fis.read(bytes);
            while ( len > 0 ) {
                fos.write(bytes, 0, len);
                len = fis.read(bytes);
            }
            fis.close();
            fos.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}