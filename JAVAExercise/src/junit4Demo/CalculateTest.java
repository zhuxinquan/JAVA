package junit4Demo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by zhuxinquan on 16-7-17.
 */
public class CalculateTest {
    @Test
    public void test(){
        fail("Not yet implemented");
    }

    @Test
    public void add(){
        assertEquals(6, new Calculate().add(3, 3));
    }
}
