package oberver_pattern;

/**
 * Created by zhuxinquan on 16-8-18.
 */
public class Main {
    public static void main(String[] args) {
        Goods g = new Goods(100);
        Person p1 = new Person("name1");
        Person p2 = new Person("name2");
        g.addObserver(p1);
        g.addObserver(p2);
        System.out.println("111111");
        g.setPrice(99);
        System.out.println("222222");
        g.setPrice(98);
        g.deleteObserver(p2);
        System.out.println("333333");
        g.setPrice(97);

    }
}
