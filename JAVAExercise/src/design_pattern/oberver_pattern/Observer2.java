package design_pattern.oberver_pattern;

/**
 * Created by zhuxinquan on 16-10-13.
 */
public class Observer2 implements Observer{
    @Override
    public void update() {
        System.out.println("Observer2 has received!");
    }
}
