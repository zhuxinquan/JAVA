package design_pattern.oberver_pattern;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by zhuxinquan on 16-8-18.
 */
public class Person implements Observer {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Goods){
            Goods g = (Goods)o;
            System.out.println(name + " update :" + g.getPrice());
        }
    }
}
