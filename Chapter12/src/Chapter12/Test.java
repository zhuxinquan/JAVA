package Chapter12;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhuxinquan on 15-12-8.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File f = new File("Circle.txt");
        System.out.println(f.exists());
        System.out.println(f.isAbsolute());
        System.out.println("文件相对路径：" + f.getPath());
        System.out.println("文件绝对路径：" + f.getAbsolutePath());
        System.out.println("文件在文件系统中的唯一标识：" + f.getCanonicalPath());
    }
}
