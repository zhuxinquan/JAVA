package design_pattern.factory_pattern.mutil_factory_pattern;

/**
 * Created by zhuxinquan on 16-10-10.
 * 多个工厂方法
 */
public class FactoryTest {
    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produceMail();
        sender.Send();
    }
}
