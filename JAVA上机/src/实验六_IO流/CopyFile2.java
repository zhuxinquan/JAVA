package 实验六_IO流;

/**
 * Created by zhuxinquan on 16-9-20.
 */

import java.io.*;

public class CopyFile2 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("./src/实验六_IO流/FileList2.java");
            FileOutputStream fos = new FileOutputStream("temp.java");
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            int len = -1;
            byte[] bytes = new byte[50];
            len = bis.read(bytes);
            while ( len > 0 ) {
                bos.write(bytes, 0, len);
                len = bis.read(bytes);
            }
            bis.close();
            bos.flush();
            bos.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}