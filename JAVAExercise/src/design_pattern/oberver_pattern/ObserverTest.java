package design_pattern.oberver_pattern;

/**
 * Created by zhuxinquan on 16-10-13.
 */
public class ObserverTest {
    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());

        sub.operation();
    }
}
