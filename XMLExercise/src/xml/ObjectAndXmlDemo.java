package xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

/**
 * 对象与xml文件的转换
 * Created by zhuxinquan on 16-1-22.
 */
public class ObjectAndXmlDemo {

    /**
     * 将对象转换成XML文件
     * @param file
     * @param obj
     */
    public static void object2XML(File file, Teacher obj){
        try {
            OutputStream out = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(out);
            //构造一个将对象输出到XML文件的工具
            XMLEncoder encoder = new XMLEncoder(bos);
            encoder.writeObject(obj);
            encoder.flush();
            encoder.close();
            bos.close();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Teacher XML2Object(File file) throws IOException {
        InputStream in = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(in);

        XMLDecoder decoder = new XMLDecoder(bis);
        Teacher teacher = (Teacher)decoder.readObject();

        decoder.close();
        bis.close();
        in.close();
        return teacher;
    }

    public static void main(String[] args) throws IOException {
        Teacher teacher = new Teacher(1, "xiaobai", "ceshi xiaobai");
        object2XML(new File("./t.xml"), teacher);

        teacher =  XML2Object(new File("./t.xml"));
        System.out.println(teacher);
    }
}
