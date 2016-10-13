package design_pattern.Decorator;

/**
 * 具体的装饰者对象：糖
 * Created by zhuxinquan on 16-6-12.
 */
public class SugarDecorator extends Decorator {

    public SugarDecorator(Drink drink) {
        super(drink);
    }

    public String description() {
        return super.description() + " + 糖";
    }

    @Override
    public float cost() {
        return super.cost() + 0.5f;
    }
}
