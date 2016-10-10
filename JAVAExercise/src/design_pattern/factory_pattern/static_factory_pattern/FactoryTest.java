package design_pattern.factory_pattern.static_factory_pattern;

import design_pattern.factory_pattern.mutil_factory_pattern.Sender;

/**
 * Created by zhuxinquan on 16-10-10.
 * 静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，
 * 不需要创建实例，直接调用即可。
 */
public class FactoryTest {
    public static void main(String[] args) {
        Sender sender = SendFactory.produceMail();
        sender.Send();
    }
}
