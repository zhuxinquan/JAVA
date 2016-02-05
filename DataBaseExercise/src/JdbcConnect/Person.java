package JdbcConnect;

/**
 * Created by zhuxinquan on 16-2-5.
 */
public class Person {
    private String name;
    private int age;
    private String description;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                '}';
    }

    public Person(String name, int age, String description) {
        this.name = name;
        this.age = age;
        this.description = description;
    }

    public Person() {
    }
}
