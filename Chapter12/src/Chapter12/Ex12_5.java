package Chapter12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by zhuxinquan on 15-12-10.
 */
public class Ex12_5 {
    public static void main(String[] args) throws IOException{
        int i, count;
        FileInputStream fin = null;
        try{
            fin = new FileInputStream(args[0]);
            count = fin.available();        //返回可读入或跳过的字节数
            fin.skip(count/2);
            while((i = fin.read()) != -1){
                System.out.print((char)i);
            }
        }catch (FileNotFoundException e){
            System.out.println("文件未找到！");
            System.exit(-1);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("用法：java Ex12_5 文件名");
            System.exit(-2);
        }catch (IOException e){
            System.out.print("读数据时发生IOException.");
            System.exit(-3);
        }finally {
            fin.close();
        }
    }
}
