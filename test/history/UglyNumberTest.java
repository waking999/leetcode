package history;

import org.junit.Assert;
import org.junit.Test;

public class UglyNumberTest {
    @Test
    public void test1() {
        UglyNumber x = new UglyNumber();

        int a;

        a = 6;
        Assert.assertTrue(x.isUgly(a));

        a = 1;
        Assert.assertTrue(x.isUgly(a));

        a = 8;
        Assert.assertTrue(x.isUgly(a));

        a = 14;
        Assert.assertTrue(!x.isUgly(a));


        a = -2147483648;
        Assert.assertTrue(!x.isUgly(a));


    }
}
