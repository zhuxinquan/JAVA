package com.zxq.serializable;

import java.io.*;

/**
 * Created by zhuxinquan on 16-12-19.
 */
public class student implements Serializable {
    public String name;
    public char gender;
    public String birthday;
    public subject sub;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        student s = new student();
        subject sb = new subject("Java", 90);
        s.sub = sb;
        s.name = "zhuxinquan";
        s.gender = 'm';
        s.birthday = "1995-11-03";
        s.stuSave(s);
        System.out.println("Save success");
        student newStu = s.stuShow();
        System.out.println("Show:");
        System.out.println(newStu.toString());
    }

    public void stuSave(student s) throws IOException {
        FileOutputStream fos = new FileOutputStream("StuDB.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.flush();
        oos.close();
        fos.close();
    }

    public student stuShow() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("StuDB.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        student s = (student) ois.readObject();
        ois.close();
        fis.close();
        return s;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birthday='" + birthday + '\'' +
                ", sub=" + sub +
                '}';
    }
}