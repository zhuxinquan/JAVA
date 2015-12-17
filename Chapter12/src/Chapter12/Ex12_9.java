package Chapter12;

import java.io.*;

/**
 * Created by zhuxinquan on 15-12-15.
 */
public class Ex12_9 {
    public static void main(String[] args) {
        try{
            FileInputStream fos = new FileInputStream("Employee.dat");
            ObjectInputStream oos = new ObjectInputStream(fos);
            /*FileOutputStream fos = new FileOutputStream("Employee.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);*/
            Employee o1, o2, o3;

            //对象输出流
            /*o1 = new Employee("dingyi", 30, 'm', true, 2000.5f);
            o2 = new Employee("nier", 24, 'f', false, 1800.5f);
            o3 = new Employee("zhangsan", 40, 'm', true, 4000.5f);
            oos.writeObject(o1);
            oos.writeObject(o2);
            oos.writeObject(o3);*/

            //对象输入流
            o1 = (Employee) oos.readObject();
            System.out.println(o1);
            o2 = (Employee) oos.readObject();
            System.out.println(o2);
            o3 = (Employee) oos.readObject();
            System.out.println(o3);
            oos.close();
        }catch (IOException e){
            System.out.println(e.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Employee implements Serializable {
    String name;
    int age;
    char sex;
    boolean isMarried;
    float salary;
    public Employee(String name, int age, char sex, boolean isMarried, float salary){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.isMarried = isMarried;
        this.salary = salary;
    }
    public String toString(){
        return name + " " + age + " " + isMarried + " " + salary;
    }
}
