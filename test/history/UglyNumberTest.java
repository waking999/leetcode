package history;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UglyNumberTest {
    @Test
    public void test1() {
        UglyNumber x = new UglyNumber();

        int a;

        a = 6;
        Assertions.assertTrue(x.isUgly(a));

        a = 1;
        Assertions.assertTrue(x.isUgly(a));

        a = 8;
        Assertions.assertTrue(x.isUgly(a));

        a = 14;
        Assertions.assertTrue(!x.isUgly(a));


        a = -2147483648;
        Assertions.assertTrue(!x.isUgly(a));


    }
}
