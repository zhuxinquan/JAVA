package ComparableAndComparator;

/**
 * Created by zhuxinquan on 16-6-1.
 */
public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        //定义对象之间的比较规则
        if(o == null){
            throw new NullPointerException();
        }
        if(this.age < o.age){
            return -1;
        }else if(this.age > o.age){
            return 1;
        }
        return 0;
    }
}
