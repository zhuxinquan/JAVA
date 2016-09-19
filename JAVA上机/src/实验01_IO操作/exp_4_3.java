package 实验01_IO操作;

import java.io.*;

/**
 * Created by zhuxinquan on 16-9-17.
 */
public class exp_4_3 {
    public static void main(String[] args) {
        try {
            OutputStream fos = new FileOutputStream("fib.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            int i = 1, j = 1;
            for(int count = 0; count < 20; count++){
                dos.writeInt(i);
                int k = i + j;
                i = j;
                j = k;
            }
            dos.flush();
            dos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            InputStream fis = new FileInputStream("fib.dat");
            DataInputStream dis = new DataInputStream(fis);
            int k = 0;
            int flag = 1;
            while(flag == 1){
                try{
                    k = dis.readInt();
                } catch (EOFException e){
                    flag = 0;
                    continue;
                }
                System.out.println(k);
            }
            dis.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
