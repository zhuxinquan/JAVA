package reflection;

/**
 * Created by zhuxinquan on 16-8-18.
 */
public class Person {
    private String name;
    private int age;
    private char sex;

    private void say(){
        System.out.println("私有方法");
    }

    public Person() {
        super();
        System.out.println("person 无参构造");
    }

    @Override
    public String toString() {
        say();
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public Person(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
