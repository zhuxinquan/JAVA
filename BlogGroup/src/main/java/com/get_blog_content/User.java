package com.get_blog_content;

/**
 * Created by zhuxinquan on 16-7-26.
 */
public class User {
    private String Name;
    private String BlogAddress;
    private String BlogType;
    private String Grade;
    private String UpdateTime;


    public User() {
    }

    public User(String name, String blogAddress, String blogType, String grade, String updateTime) {
        Name = name;
        BlogAddress = blogAddress;
        BlogType = blogType;
        Grade = grade;
        UpdateTime = updateTime;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBlogAddress() {
        return BlogAddress;
    }

    public void setBlogAddress(String blogAddress) {
        BlogAddress = blogAddress;
    }

    public String getBlogType() {
        return BlogType;
    }

    public void setBlogType(String blogType) {
        BlogType = blogType;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        UpdateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", BlogAddress='" + BlogAddress + '\'' +
                ", BlogType='" + BlogType + '\'' +
                ", Grade='" + Grade + '\'' +
                ", UpdateTime='" + UpdateTime + '\'' +
                '}';
    }
}
