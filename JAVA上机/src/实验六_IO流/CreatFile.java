package 实验六_IO流;

import java.io.*;

/**
 * Created by zhuxinquan on 16-9-20.
 */
public class CreatFile {
    public static void main(String[] args) {
        try {
            //字节流
            FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
            String string = "2016年G20杭州峰会于9月4日至5日在杭州市举行。9月的杭州，迎来地球“最强天团”，这是一场云集全球多国政坛大佬的“超级巨星”的峰会。";
            fileOutputStream.write(string.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();

            //字符流
            Writer writer = new OutputStreamWriter(new FileOutputStream("test2.txt"));
            writer.write(string);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
