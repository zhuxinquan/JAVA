package 实验01_IO操作;

import java.io.*;
import java.util.Vector;

/**
 * Created by zhuxinquan on 16-9-18.
 */
public class exp_4_4 {
    public static void main(String[] args) {
        int c;
        Vector files = new Vector();
        files.addElement("./1.txt");
        files.addElement("./logo.png");
        InputStreamEnumerator e = new InputStreamEnumerator(files);
        InputStream input = new SequenceInputStream(e);
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("merge.dat");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            while((c = input.read()) != -1){
                System.out.print((char)c);
                outputStream.write((byte)c);
            }
            input.close();
            outputStream.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
