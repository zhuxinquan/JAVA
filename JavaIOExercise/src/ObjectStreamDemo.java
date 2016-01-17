import java.io.*;

/**
 * Created by zhuxinquan on 16-1-17.
 */

//需要序列化的对象必须实现Serializabliab接口，并且使用transient关键字生声明的属性将不会被序列化
class Dog implements Serializable{
    private String name;
    private int age;

    public Dog() {
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
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    public Dog(String name, int age) {

        this.name = name;
        this.age = age;
    }
}

public class ObjectStreamDemo {
    /**
     * 从文件中读入一个对象
     */
    public static void readerObject(){
        InputStream in = null;
        try {
            in = new FileInputStream("./obj");
            //由字节流构造一个对象流
            ObjectInputStream ois = new ObjectInputStream(in);
            int num = ois.readInt();
            Dog dog = (Dog)ois.readObject();
            System.out.println("num = " + num + "\n" + dog);
            ois.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将对象写入文件
     */
    public static void writerObject(){
        try {
            OutputStream out = new FileOutputStream("./obj");
            //由输出流构造一个对象流
            ObjectOutputStream oos = new ObjectOutputStream(out);

            Dog dog = new Dog("test", 18);
            oos.writeInt(2016);
            oos.writeObject(dog);
            oos.close();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将一组（数组形式）对象序列化到文件中
     */
    public static void writerObject2(){
        try {
            OutputStream out = new FileOutputStream("./obj");
            ObjectOutputStream oos = new ObjectOutputStream(out);

            Dog[] dogs = {new Dog("1", 1), new Dog("2", 2), new Dog("3", 3)};
            //一次性将对象数组写入文件
            oos.writeObject(dogs);
            oos.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从文件中读取对象数组
     */
    public static void readerObject2(){
        try {
            InputStream in = new FileInputStream("./obj");
            ObjectInputStream ois = new ObjectInputStream(in);

            Dog[] dogs = (Dog[])ois.readObject();
            ois.close();
            in.close();
            for(Dog dog :dogs){
                System.out.println(dog);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        readerObject();
//        writerObject2();
        readerObject2();
    }

}
