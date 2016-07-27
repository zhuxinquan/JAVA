package set;

/**
 * 操作用户类
 * Created by zhuxinquan on 16-2-21.
 */
public class User implements Comparable<User>{
    private String name;
    private int age;
    private String sex;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public User() {
    }

    public User(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /**
     * 自定义对象是否重复的判断条件是：先判断hashCode是否相等，如果不相等，那么一定不是
     * 如果相等，再调用equals方法进行判断，如果equals方法返回true，表示对象是同一个
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (!name.equals(user.name)) return false;
        return sex.equals(user.sex);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + sex.hashCode();
        return result;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public int compareTo(User o) {
        if(o == null){
            throw new NullPointerException("参数不能为空");
        }
        if(this.age < o.age){
            return -1;
        }else if(this.age >= o.age){
            return 1;
        }
        return 0;
    }
}
