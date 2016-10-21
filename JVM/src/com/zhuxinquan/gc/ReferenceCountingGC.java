package com.zhuxinquan.gc;

import org.junit.Test;

/**
 * Created by zhuxinquan on 16-10-17.
 */
public class ReferenceCountingGC {
    public Object instance = null;

    private byte[] bigSize = new byte[2 * 1024 * 1024];

    @Test
    public void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }
}
