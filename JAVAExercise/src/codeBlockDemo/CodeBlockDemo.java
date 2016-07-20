package codeBlockDemo;

/**
 * Created by zhuxinquan on 16-7-20.
 * 代码块：
 * 1.构造块先于构造方法执行，每次实例化一个新的对象就执行一次构造块
 * 2.静态构造块只执行一次，在类加载时执行
 */
public class CodeBlockDemo {

    {
        System.out.println("构造块");
    }

    public CodeBlockDemo(){
        System.out.println("构造方法");
    }

    static {
        System.out.println("静态构造块");
    }

    public static void main(String[] args) {
        //CodeBlockDemo cd1 = new CodeBlockDemo();
        //CodeBlockDemo cd2 = new CodeBlockDemo();

        {
            String info = "普通代码块1";
            System.out.println(info);
        }
        //info作用域为普通代码块内部
        //System.out.println(info);
    }
}
