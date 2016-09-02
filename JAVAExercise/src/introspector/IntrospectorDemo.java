package introspector;

/**
 * Created by zhuxinquan on 16-8-18.
 */
public class IntrospectorDemo {
    public static void main(String[] args) {
        Dog dog = DogFactory.getDog("dog");
        System.out.println(dog);
    }
}