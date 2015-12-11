package Chapter12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by zhuxinquan on 15-12-11.
 */
public class Ex12_7 {
    public static void main(String[] args) {
        String str = "白日依山尽\n";
        char[] ch = str.toCharArray();
        FileWriter fw = null;
        FileReader fr = null;
        try{
            fw = new FileWriter("登鹤雀楼.txt");     //在实例化一个文件字符流时
            fw.write(ch);                                 //就指定是否进行追加
            fw.write("黄河入海流\n");
            fw.close();
        }catch(IOException e){
            System.out.println("流的创建、写和关闭都可能产生IOException异常");
            System.exit(-1);
        }
        try{
            fr = new FileReader("登鹤雀楼.txt");
            char[] ch1 = new char[100];
            while((fr.read(ch1) != -1)) {
                System.out.println(ch1);
            }
            /*int i;
            while((i = fr.read()) != -1){
                System.out.print((char)i);
            }*/
            System.out.println();
            fr.close();
        }catch(FileNotFoundException e){
            System.out.println("文件未找到");
            System.exit(-2);
        }catch (IOException e){
            System.err.println("读和关闭文件都可能产生IOException异常");
            System.exit(-3);
        }
    }
}
