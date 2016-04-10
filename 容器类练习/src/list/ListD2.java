package list;

import arraylist.User;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhuxinquan on 16-3-24.
 */
public class ListD2 {
    public static void main(String[] args) {
        List<User> users = new LinkedList<>();
        User u1 = new User("1", 1, "m");
        User u2 = new User("2", 2, "w");
        User u3 = new User("3", 3, "m");
        users.add(u1);
        users.add(u2);
        users.add(u3);
        List<User> sub = users.subList(0, 2);
        System.out.println("user:" + users);
        System.out.println("sub:" + sub);
        User u = sub.get(0);
        u.setName("4");
        System.out.println(users);
    }
}
