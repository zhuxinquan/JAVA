package ObjectClone;

/**
 * 一个类要实现克隆功能比价实现Cloneable接口,该接口是一个标记接口
 * 同时必须重写Object类中的clone方法
 * Created by zhuxinquan on 16-6-2.
 */
public class Cat implements Cloneable{
    private String name;
    private int age;

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
