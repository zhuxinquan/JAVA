package 实验01_IO操作;

/**
 * Created by zhuxinquan on 16-9-21.
 */
import java.util.*;
import java.text.*;
import java.util.zip.*;
import java.io.*;

class UnZipper{
    String zipSource;
    UnZipper(String zipFile){
        zipSource = zipFile;
    }

    public void unCompress(){
        try{
            ZipFile zf = new ZipFile(zipSource);
            Enumeration es = zf.entries();
            System.out.println("开始解压缩");
            while(es.hasMoreElements()){
                ZipEntry ze = (ZipEntry)es.nextElement();
                System.out.println("当前解压文件为：" + ze.getName());
                if(ze.isDirectory()){
                    File ff = new File("newZip", ze.getName());
                    ff.mkdirs();
                }else{
                    InputStream in = zf.getInputStream(ze);
                    File ff = new File("newZip", ze.getName());
                    File fp = ff.getParentFile();
                    fp.mkdirs();
                    FileOutputStream fout = new FileOutputStream(ff);
                    int c;
                    while((c = in.read()) != -1)fout.write(c);
                }
            }
        }catch(Exception e){
            System.err.println(e.toString());
        }
    }

    public static void main(String [] args){
        UnZipper uz = new UnZipper("history.zip");
        uz.unCompress();
    }
}