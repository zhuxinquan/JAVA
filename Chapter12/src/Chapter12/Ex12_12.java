package Chapter12;

import java.io.*;

/**
 * Created by zhuxinquan on 15-12-13.
 */
public class Ex12_12 {
    public static void main(String[] args)  throws IOException{
        InputStream source = null;
        BufferedInputStream bufIn = null;
        OutputStream dest = null;
        BufferedOutputStream bufOut = null;
        try{
            source = new FileInputStream("test.jpg");
            bufIn = new BufferedInputStream(source);
            dest = new FileOutputStream("copytest.jpg");
            bufOut = new BufferedOutputStream(dest);
            while(bufIn.available() > 0){
                bufOut.write(bufIn.read());
            }
            bufOut.flush();
            System.out.println("successfully copy");
        }catch (FileNotFoundException e){
            System.err.println(e.toString());
        }finally {
            bufOut.close();
            bufIn.close();
            source.close();
            dest.close();
        }
    }
}
