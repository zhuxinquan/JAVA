package wrapperclass;

/**
 * Created by zhuxinquan on 16-7-22.
 * 包装类
 */
public class WrapperClassDemo {
    public static void main(String[] args) {
        /**
         * 包装类中使用到了享元设计模式：
         * 它使用共性对象，用来尽可能减少内存使用量以及分享资讯给尽可能多大额相似对象
         * 适用于当大量对象只是重复因而导致无法令人接受的是哟个大量内存
         * 此处对于Integer小于一个字节的数据就会返回相同的对象
         */
        //Integer直接赋值时，当值为1个字节内的数时（-128~127），将使用同一个对象
        Integer int1 = 10;
        Integer int2 = 10;
        System.out.println(int1 == int2);
    }
}
