package Chapter12;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhuxinquan on 15-12-8.
 */
public class SortFileAndDir {
    public static void main(String[] args) {
        File dir = new File(System.getProperty("user.dir"));
        if(args.length > 0) dir = new File(args[0]);
        if(dir.exists() && dir.isDirectory())
            printDirInfo(dir.listFiles());
        else
            System.out.println("目录不存在");
    }
    private static void printDirInfo(File[] listF){
        Arrays.sort(listF, new FileNameSorter());
        for(int i = 0; i < listF.length; i++){
            if(listF[i].isDirectory())
                System.out.print("Directory");
            else
                System.out.print(listF[i].length() + "bytes.");
            System.out.println("\t" + listF[i]);
        }
    }
}

class FileNameSorter implements Comparator{
    public int compare(Object o1, Object o2){
        File f1 = (File)o1, f2 = (File)o2;
        if(f1.isDirectory()){
            if(f2.isDirectory())
                return f1.getName().compareTo(f2.getName());
            else
                return -1;              //外部sort函数是升序排列，则将目录排在文件之前
        }else{
            if(f2.isDirectory())
                return 1;
            else
                return f1.getName().compareTo(((File) o2).getName());
        }
    }
}