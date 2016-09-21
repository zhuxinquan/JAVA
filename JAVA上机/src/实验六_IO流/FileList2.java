package 实验六_IO流;

import java.io.File;

public class FileList2{
    public static void main(String[] args){
        File dir=new File(".");
        File files[]=dir.listFiles();
        System.out.println(dir);
        for(int i=0;i<files.length;i++){
            if(files[i].isFile())
                System.out.println("\t"+files[i].getName());
            else
                System.out.println("<DIR>\t"+files[i].getName());
        }
    }
}