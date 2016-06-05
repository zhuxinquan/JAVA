package ComparableAndComparator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhuxinquan on 16-6-1.
 */
public class PersonSortDemo{
    public static void main(String[] args) {
        String[] names = {"hell", "erteri", "fedfs"};
        Person2[] persons2 = {
                new Person2("hell", 27), new Person2("erteri", 29),
                new Person2("fedfs", 34)
        };
        Arrays.sort(names);
        System.out.println(Arrays.toString(names));

        //自定义对象数组排序
//        Arrays.sort(persons, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                if(o1.getAge() > o2.getAge()){
//                    return 1;
//                }
//                return 0;
//            }
//        });
        Arrays.sort(persons2, new Person2Comparator());
        System.out.println(Arrays.toString(persons2));
    }
}
