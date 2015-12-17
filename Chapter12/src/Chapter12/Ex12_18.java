package Chapter12;

import java.io.*;

/**
 * Created by zhuxinquan on 15-12-15.
 */
public class Ex12_18 {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入，每次输入一行回车，直接回车结束输入:");
        try{
            FileWriter fw = new FileWriter("Ex12_18.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter o = new PrintWriter(bw);
            String line = null;
            while((line = in.readLine()) != null){
                if(line.length() == 0) break;
                o.println(line);
            }
            o.close();
            in.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
