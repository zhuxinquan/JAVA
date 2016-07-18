package junitTest;

import junitTest.Calulate;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by zhuxinquan on 16-7-18.
 */
public class CalculateTest {
    @Test
    public void testAdd(){
        assertEquals(6, new Calulate().add(3, 3));
    }

    @Test
    public void testSub(){
        assertEquals(3, new Calulate().sub(5, 2));
    }

    @Test
    public void testMul(){
        assertEquals(6, new Calulate().mul(2, 3));
    }

    @Test
    public void testDiv(){
        assertEquals(2, new Calulate().div(6,  3));
    }
}
