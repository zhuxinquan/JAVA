package design_pattern.prototype_pattern;

/**
 * Created by zhuxinquan on 16-10-12.
 */
public class Prototype implements Cloneable {
    public Object clone() throws CloneNotSupportedException {
        Prototype proto = (Prototype) super.clone();
        return proto;
    }
}
