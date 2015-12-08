package Chapter8;

/**
 * Created by zhuxinquan on 15-12-7.
 */

class MyExceptionClass extends Exception{
    double x;
    MyExceptionClass(double x){
        super("输出错误！" + "x=" + x + ", 当x的平方根为负数时引发的自定义异常.");
        this.x = x;
    }
    public String toString(){
        return "MyExceptionClass:输入错误！";
    }
}

class SqrtCalculation{
    void calculate(double x){
        try{
            if(x < 0.0) throw new MyExceptionClass(x);
            else System.out.println(Math.sqrt(x));
        }catch(MyExceptionClass e){
            System.out.println("calculate() is handing this MyExceptionClass object.");
            System.out.println("object is " + e);
        }
    }
}

public class Ex8_10 {
    public static void main(String[] args) {
        SqrtCalculation obj =  new SqrtCalculation();
        obj.calculate(-4);
    }
}
