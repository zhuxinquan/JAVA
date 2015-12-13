package Chapter12;

import java.io.*;

/**
 * Created by zhuxinquan on 15-12-13.
 */
public class Ex12_8 {
    public static void main(String[] args) throws IOException{
        String str = "ByteArrayOutputStream 类向内存中的字节数组写数据.";
        byte[] buf = str.getBytes();
        ByteArrayOutputStream baout = new ByteArrayOutputStream();
        baout.write(buf);
        System.out.println("写入流中字节转换为字符串：" + baout.toString());
        byte[] b = baout.toByteArray();

        OutputStream file = new FileOutputStream("Ex12_8.txt");
        baout.writeTo(file);
        baout.close();

        ByteArrayInputStream bain = new ByteArrayInputStream(b);
        byte[] bArray = new byte[b.length];
        System.out.print("从流中输入的数据是：");
        while(bain.read(bArray) != -1);
        /*int i;
        while((i = bain.read()) != -1){
            System.out.print((byte)i);
        }*/
        System.out.println(new String(bArray));
        bain.close();
    }
}
