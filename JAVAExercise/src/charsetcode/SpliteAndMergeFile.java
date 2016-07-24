package charsetcode;

import java.io.*;

/**
 * Created by zhuxinquan on 16-7-23.
 */
public class SpliteAndMergeFile {
    /**
     * 合并文件
     * @param dest 目标路径
     * @param files 要合并的文件列表
     */
    public static void merge(String dest, File... files){
        String filename =  files[0].getName();
        filename = filename.substring(0, filename.lastIndexOf("-"));
        try {
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(dest + File.separator + filename));
            BufferedInputStream bis = null;
            byte[] bytes = new byte[1024];
            int len = -1;
            for(int i = 0; i < files.length; i++){
                bis = new BufferedInputStream(new FileInputStream(files[i]));
                while((len = bis.read(bytes)) != -1){
                    bos.write(bytes);
                    bos.flush();
                }
                bis.close();
            }
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 分割文件
     * @param src 要分割的源文件大小
     * @param mb 每个文件的大小
     * @param dest
     */
    public static void split(String src, int mb, String dest){
        File srcFile = new File(src);
        if(!srcFile.exists()){
            return ;
        }
        long countSize = srcFile.length();
        //要分割的每个文件的大小
        long filesize = 1024 * 1024 * mb;

        int num = 0; //要分割的份数
        if(countSize%filesize == 0){
            num = (int)(countSize/filesize);
        }else {
            num = (int)(countSize/filesize) + 1;
        }

        try {
            InputStream in = new FileInputStream(srcFile);
            BufferedInputStream bis = new BufferedInputStream(in);
            BufferedOutputStream bos = null;
            byte[] bytes = new byte[1024 * 1024];
            int len = -1;
            for(int i = 0; i < num; i++){
                String newFile = dest + File.separator + srcFile.getName() + "-" + i + ".dat";
                bos = new BufferedOutputStream(new FileOutputStream(newFile));
                int count = 0;
                while((len = bis.read(bytes)) != -1){
                    bos.write(bytes);
                    bos.flush();
                    count += len;
                    if(count >= filesize){
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        merge("./src", new File("./src/file-0.dat"),
                new File("./src/file-1.dat"),
                new File("./src/file-2.dat"),
                new File("./src/file-3.dat"),
                new File("./src/file-4.dat"),
                new File("./src/file-5.dat"),
                new File("./src/file-6.dat"),
                new File("./src/file-7.dat"),
                new File("./src/file-8.dat"));
//        split("./file", 50, "./src/");
    }
}
