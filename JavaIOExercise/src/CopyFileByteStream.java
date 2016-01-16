import java.io.*;

/**
 * Created by zhuxinquan on 16-1-16.
 */
public class CopyFileByteStream {

    /**
     * 使用字节流实现文件的复制
     * @param src 源路径
     * @param dest 目标路径
     */
    public static void copyFile(String src, String dest) throws IOException {
        //lastIndexOf返回字符串中第一次出现参数的位置，若字符串中未出现该字符，则返回-1
        //substring方法将字符串从参数位置截取后半部分，
        String ext = src.substring(src.lastIndexOf("/"));
        File srcFile = new File(src);
        File destFile = new File(dest + File.separator + ext);
        InputStream in = null;
        OutputStream out = null;

        in = new FileInputStream(srcFile);
        out = new FileOutputStream(destFile);

        byte[] bytes = new byte[20];
        int len = -1;
        while((len = in.read(bytes)) != -1){
            out.write(bytes, 0, len);
        }
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        String src = "/home/zhuxinquan/音乐/亲爱的-潘玮柏.mp3";
        String dest = "/home";
        copyFile(src, dest);
    }
}
