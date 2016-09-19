package 实验01_IO操作;

/**
 * Created by zhuxinquan on 16-9-18.
 */
import java.util.zip.*;
import java.io.*;
class Zipper{
    String zipTarget;
    String zipSource;
    Zipper(String fileTarget, String fileSource){
        zipTarget = fileTarget;
        zipSource = fileSource;
    }
    public void compress(){
        try{
            FileOutputStream fout = new FileOutputStream(zipTarget);
            ZipOutputStream zout = new ZipOutputStream(fout);
            zout.setLevel(9);
            File file = new File(zipSource);
            if(file.isDirectory()){
                String [] fileList = file.list();
                for(int i=0;i<fileList.length; i++){
                    ZipEntry ze = new ZipEntry(fileList[i]);
                    System.out.println("正在压缩文件 " + fileList[i]);
                    FileInputStream fin = new FileInputStream(file + file.separator + fileList[i]);
                    zout.putNextEntry(ze);
                    int c = -1;
                    while((c = fin.read()) != -1){
                        zout.write(c);
                    }
                    fin.close();
                }
            }
            zout.closeEntry();
            zout.close();
        }catch(Exception e){
            System.err.println(e.toString());
        }
    }
    public static void main(String [] args){
        Zipper z = new Zipper("history.zip", "zip");
        z.compress();
    }
}
