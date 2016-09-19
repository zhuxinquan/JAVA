package 实验01_IO操作;

import java.io.File;

/**
 * Created by zhuxinquan on 16-9-18.
 */
public class exp_4_2 {
    public static void main(String[] args) {
        File dir = new File(System.getProperty("user.dir"));
        File filename = null;
        if(dir.isDirectory()){
            System.out.println("Directory of " + dir);
            String listing[] = dir.list();
            for(int i = 0; i < listing.length; i++){
                System.out.println("\t" + listing[i]);

                filename = new File(listing[i]);
                if(filename.isDirectory()){
                    String listing2[] = filename.list();
                    for(int j = 0; j < listing2.length; j++){
                        System.out.println("\t\t" + listing2[j]);
                    }
                }
            }
        }
    }
}
