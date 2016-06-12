package Decorator;

/**
 * 装饰者基类
 * Created by zhuxinquan on 16-6-12.
 */
public abstract class Decorator implements Drink{

    //要装饰的对象
    private Drink drink;

    public Decorator(Drink drink){
        this.drink = drink;
    }

    @Override
    public String description() {
        return drink.description();
    }

    @Override
    public float cost() {
        return drink.cost();
    }
}
