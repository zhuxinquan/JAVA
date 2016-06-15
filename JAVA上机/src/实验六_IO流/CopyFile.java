package 实验六_IO流;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("./src/实验六_IO流/CopyFile1.java");
//            Scanner in = new Scanner(System.in);
//            String filename = in.next();
            FileOutputStream fos = new FileOutputStream("temp.txt");
            int read = fis.read();
            while ( read != -1 ) {
                fos.write(read);
                read = fis.read();
            }
            fis.close();
            fos.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}