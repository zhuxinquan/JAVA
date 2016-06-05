package ComparableAndComparator;

import java.util.Comparator;

/**
 * 自定义类比较器
 * Created by zhuxinquan on 16-6-1.
 */
public class Person2Comparator implements Comparator<Person2>{

    @Override
    public int compare(Person2 o1, Person2 o2) {
        if(o1 == null || o2 == null){
            throw new NullPointerException();
        }

        if(o1.getAge() < o2.getAge()){
            return -1;
        }else if(o1.getAge() > o2.getAge()){
            return 1;
        }
        return 0;
    }
}
