package Decorator;

/**
 * 被装饰者对象的接口
 * Created by zhuxinquan on 16-6-12.
 */
public interface Drink {

    //饮料描述信息
    public String description();

    //计算价格
    public float cost();
}
