package com.zxq.serializable.transient_;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Created by zhuxinquan on 16-12-19.
 */
public class StuShow {
    public static void main(String [] argv)throws Exception{
        FileInputStream fis = new FileInputStream("StuDB.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student Emily = (Student)ois.readObject();
        Student Jeffy = (Student)ois.readObject();
        ois.close();
        fis.close();
        Emily.show();
        Jeffy.show();
    }
}
