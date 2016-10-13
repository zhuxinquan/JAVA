package design_pattern.oberver_pattern;

/**
 * Created by zhuxinquan on 16-10-13.
 */
public class Observer1 implements Observer{
    @Override
    public void update() {
        System.out.println("observer1 has received!");
    }
}
