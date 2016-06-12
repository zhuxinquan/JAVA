package Decorator;

/**
 * 具体装饰者对象：鸡蛋
 * Created by zhuxinquan on 16-6-12.
 */
public class EggDecorator extends Decorator {
    public EggDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public String description() {
        return super.description() + " + 鸡蛋";
    }

    @Override
    public float cost() {
        return super.cost() + 2.0f;
    }
}
