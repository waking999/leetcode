package history;


import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class NumberOfBitsTest {

    @Test
    public void test1() {
        NumberOfBits x = new NumberOfBits();

        int a;
        int e;

        a = 11;
        e = 3;
        Assert.assertEquals(e, x.hammingWeight(a));

        a = 255;
        e = 8;
        Assert.assertEquals(e, x.hammingWeight(a));

        a = Integer.MIN_VALUE;
        e = 1;
        Assert.assertEquals(e, x.hammingWeight(a));

        System.out.println("done");

    }
}
