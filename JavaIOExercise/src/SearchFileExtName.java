import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;

/**
 * Created by zhuxinquan on 16-1-13.
 * 查找特定后缀名的文件（使用递归）
 */

public class SearchFileExtName {

    public static void findFile(File file, String extName){
        if(file == null){
            return;
        }
        if(file.isDirectory()){
            File[] fs = file.listFiles();
            if(fs != null){
                for(File f:fs){
                    findFile(f, extName);
                }
            }
        }else{
            String path = file.getPath().toLowerCase();
            if(path.endsWith(extName)){
                System.out.println(file.getPath());
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("../");
        String extName = ".java";
        findFile(file, extName);
    }
}
