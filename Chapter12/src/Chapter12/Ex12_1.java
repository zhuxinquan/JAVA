package Chapter12;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhuxinquan on 15-12-8.
 */
public class Ex12_1 {
    public static void main(String[] args)throws IOException {
        File myDir = new File("/home/zhuxinquan/myDir");
        if(!myDir.exists())
            myDir.mkdir();
        File myDir1 = new File(myDir, "myDir1");
        if(!myDir1.exists())
            myDir1.mkdirs();
        File file = new File(myDir1, "my.txt");
        if(!file.exists())
            file.createNewFile();
        listDir(myDir);
        deleteDir(myDir);
    }
    static void deleteDir(File f){      //递归删除
        if(f.isFile()){
            f.delete();
            return ;
        }
        File[] fFiles = f.listFiles();
        if(fFiles.length == 0){
            f.delete();
        }else{
            for(int i = 0; i < fFiles.length; i++){
                deleteDir(fFiles[i]);
            }
            f.delete();
        }
    }
    static void listDir(File dir){
        File[] listF = dir.listFiles();
        String info = "目录：" + dir.getName() + "{";
        for(int i = 0; i < listF.length; i++){
            info += listF[i].getName() + " ";
        }
        info += "}";
        System.out.println(info);
        for(int i = 0; i < listF.length; i++){
            File f = listF[i];
            if(f.isFile())
                printFileInfo(f);
            else
                listDir(f);
        }
    }
    static void printFileInfo(File f){
        System.out.println("文件名：" + f.getName());
        System.out.println("文件父路径：" + f.getParent());
        System.out.println("文件可读？：" + f.canRead());
        System.out.println("文件大小：" + f.length() + "字节");
    }
}