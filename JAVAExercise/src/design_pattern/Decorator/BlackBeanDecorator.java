package design_pattern.Decorator;

/**
 * 具体的装饰者对象：黑豆
 * Created by zhuxinquan on 16-6-12.
 */
public class BlackBeanDecorator extends Decorator {
    public BlackBeanDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public String description() {
        return super.description() + " + 黑豆";
    }

    @Override
    public float cost() {
        return super.cost() + 3.0f;
    }
}
