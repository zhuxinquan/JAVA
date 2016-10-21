package com.zhuxinquan.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuxinquan on 16-10-17.
 * Java堆内存溢出测试
 * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while(true){
            list.add(new OOMObject());
        }
    }
}
