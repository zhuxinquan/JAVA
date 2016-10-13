package design_pattern.oberver_pattern;

/**
 * Created by zhuxinquan on 16-10-13.
 */
public class MySubject extends AbstractSubject{
    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }
}
