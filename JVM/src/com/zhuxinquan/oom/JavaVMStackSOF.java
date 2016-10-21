package com.zhuxinquan.oom;

/**
 * Created by zhuxinquan on 16-10-17.
 * 虚拟机栈和本地方法栈OOM测试
 * VM Args：-Xss2228k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak(){
//        System.out.println(stackLength);
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable{
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try{
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("Stack length:" + oom.stackLength);
            throw e;
        }
    }
}
