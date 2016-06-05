package MathAndRandom;

/**
 * Created by zhuxinquan on 16-5-31.
 */
public class MathDemo {
    public static void main(String[] args) {
        //random返回大于0.0小于1.0double值
        System.out.println("Math.random() = " + Math.random());
        //round返回最接近参数并等于某一整数的double值（四舍五入）
        System.out.println("Math.round(98.56) = " + Math.round(98.56d));
        //取两位小数
        System.out.println("Math.round(88.56789) = " + Math.round(88.56789 * 100) / 100.0);
        System.out.println("Math.sqrt(2d) = " + Math.sqrt(2d));
    }
}
