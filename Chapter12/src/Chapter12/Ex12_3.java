package Chapter12;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by zhuxinquan on 15-12-8.
 */
public class Ex12_3 {
    public static void main(String[] args) {
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                System.out.println("根路径："+dir.getPath() + "\t子路径：" + name);
                File currFile = new File(dir, name);
                if(currFile.isFile() && name.indexOf(".java") != -1)
                    return true;
                else
                    return false;
            }
        };
        String[] listS = new File("/home/zhuxinquan/IdeaProjects/Chapter12/src/Chapter12/").list(filter);
        for(int i = 0; i < listS.length; i++){
            System.out.println(listS[i]);
        }
    }
}
