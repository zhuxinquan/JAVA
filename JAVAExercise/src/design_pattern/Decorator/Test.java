package design_pattern.Decorator;

/**
 * 测试
 * Created by zhuxinquan on 16-6-12.
 */
public class Test {
    public static void main(String[] args) {
        //生产豆浆
        Drink soya = new SoyaBeanMilk();
        //加鸡蛋
        EggDecorator eggsoya = new EggDecorator(soya);
        //加糖
        SugarDecorator sugarEggSoya = new SugarDecorator(eggsoya);
        //加黑豆
        BlackBeanDecorator blackBeanSugarEggSoya = new BlackBeanDecorator(sugarEggSoya);

        System.out.println(blackBeanSugarEggSoya.description());
        System.out.println(blackBeanSugarEggSoya.cost());
    }
}
