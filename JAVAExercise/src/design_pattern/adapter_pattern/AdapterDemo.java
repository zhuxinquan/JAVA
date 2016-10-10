package design_pattern.adapter_pattern;

/**
 * Created by zhuxinquan on 16-7-21.
 * 适配器模式：将一个类的接口转换成客户希望的另外一个接口
 * 适配器模式能够使原本由于接口不兼容而不能在一起工作的那些类在一起工作
 * OO设计原则：对修改关闭，对扩展开放
 */
public class AdapterDemo {
    public static void main(String[] args) {
        PowerA powerA = new PowerAImpl();
        start(powerA);
        PowerB powerB = new PowerBImpl();
        PowerAAdapter pa = new PowerAAdapter(powerB);
        start(pa);
    }

    public static void start(PowerA powerA){
        powerA.insert();
    }
}

//适配器
class PowerAAdapter implements PowerA{

    private PowerB powerB;

    public PowerAAdapter(PowerB powerB) {
        this.powerB = powerB;
    }

    @Override
    public void insert() {
        powerB.connect();
    }
}

interface PowerA{
    public void insert();
}

class PowerAImpl implements PowerA{

    @Override
    public void insert() {
        System.out.println("PowerA work");
    }
}

interface PowerB {
    public void connect();
}

class PowerBImpl implements PowerB{

    @Override
    public void connect() {
        System.out.println("PowerB work");
    }
}