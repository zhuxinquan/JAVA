package design_pattern.factory_pattern.abstract_factory_pattern;

import design_pattern.factory_pattern.mutil_factory_pattern.Sender;

/**
 * Created by zhuxinquan on 16-10-10.
 * 抽象工厂模式：当需要增加功能时，只需要做一个实现类，实现功能类（Sender），同时
 * 做一个工厂类，实现工厂类公用的接口
 * 所以，抽象工厂模式等同于有两个公用的接口，一个是功能类的接口，一个是工厂类的接口
 */
public class Test {
    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.Send();
    }
}
