package leetcode.success.math;

import common.Util;
import org.junit.Test;

public class PowTest {
    @Test
    public void test1() {
        Pow s = new Pow();

        double x;
        int n;
        double expect;
        double output;

        x = 2.0;
        n = 2;
        expect = 4.0;
        output = s.myPow(x, n);
        Util.verify(expect, output, 1);

        x = 34.00515;
        n = -3;
        expect = 0.00003;
        output = s.myPow(x, n);
        Util.verify(expect, output, 2);

        x = -13.62608;
        n = 3;
        expect = -2529.95504;
        output = s.myPow(x, n);
        Util.verify(expect, output, 3);

        x = 2;
        n = -2147483648;
        expect = 0.0000;
        output = s.myPow(x, n);
        Util.verify(expect, output, 4);

    }
}
