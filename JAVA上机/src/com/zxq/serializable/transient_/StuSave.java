package com.zxq.serializable.transient_;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Created by zhuxinquan on 16-12-19.
 */
public class StuSave {
    public static void main(String [] argv)throws Exception{
        Student Emily = new Student("E. Jordan", '男', "1901-01-01");
        Student Jeffy = new Student("E. Jordan", '男', "1901-01-01");
        FileOutputStream fos = new FileOutputStream("StuDB.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Emily);
        oos.writeObject(Jeffy);
        oos.flush();
        oos.close();
        fos.close();
    }
}
