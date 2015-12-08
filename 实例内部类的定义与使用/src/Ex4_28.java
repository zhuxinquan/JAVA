/**
 * Created by zhuxinquan on 15-11-22.
 */

class Outer1{
    private int outVar = 0;
    Inner inner = new Inner();
    public class Inner{
        public void showOutVar(){
            outVar++;
            System.out.println("outVar = "+ outVar);
        }
    }
}

public class Ex4_28 {
    public static void main(String[] args){
        Outer1 object = new Outer1();
        Outer1.Inner obj = object.new Inner();
        obj.showOutVar();
        object.inner.showOutVar();          //其后的inner必须由外部类实例化之后才可使用
        Outer1.Inner o = new Outer1().new Inner();
        o.showOutVar();
        object.inner.showOutVar();
    }
}
