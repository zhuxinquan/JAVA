package design_pattern.Decorator;

/**
 * 具体的杯装饰者对象:纯豆浆
 * Created by zhuxinquan on 16-6-12.
 */
public class SoyaBeanMilk implements Drink{

    @Override
    public String description() {
        return "纯豆浆";
    }

    @Override
    public float cost() {
        return 5f;
    }
}
