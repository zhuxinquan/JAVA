package com.zxq.serializable.transient_;

import java.io.Serializable;

/**
 * Created by zhuxinquan on 16-12-19.
 */
public class Student implements Serializable {
    String name;
    transient char gender;
    String birthday;
    public Student(String name,char gender,String birthday){
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }
    public void show(){
        System.out.println("学生: " + name);
        System.out.println("姓名: " + name);
        System.out.println("性别: " + gender);
        System.out.println("生日: " + birthday);
    }
}
