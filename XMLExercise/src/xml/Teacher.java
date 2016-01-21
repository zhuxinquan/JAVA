package xml;
/**
 * Created by zhuxinquan on 16-1-20.
 */
public class Teacher {
    private int id;
    private String name;
    private String desc;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public Teacher() {
    }

    public Teacher(int id, String name, String desc) {

        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
