package Chapter12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by zhuxinquan on 15-12-10.
 */
public class Ex12_6 {
    public static void main(String[] args) {
        int i;
        File myDir = new File("myDir");
        if(!myDir.exists()){
            myDir.mkdir();
        }
        File myFile = new File(myDir, "my.txt");
        try{
            FileOutputStream fout = new FileOutputStream(myFile);
            System.out.print("请输入（以#结束）：");
            while((i = System.in.read()) != '#'){
                fout.write(i);
            }
            fout.close();
        }catch (FileNotFoundException e){
            System.out.println("文件未找到！");
            System.exit(-1);
        }catch (IOException e){
            System.out.println("读文件时或关闭文件时发生IOException异常.");
            System.exit(-1);
        }
    }
}
