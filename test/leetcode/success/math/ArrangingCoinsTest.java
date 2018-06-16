package leetcode.success.math;

import org.junit.Test;

import static common.Util.verify;

public class ArrangingCoinsTest {
    @Test
    public void test1() {
        ArrangingCoins s = new ArrangingCoins();

        int n;
        int expect;
        int output;

        n = 5;
        expect = 2;
        output = s.arrangeCoins(n);
        verify(expect, output, 1);

        n = 8;
        expect = 3;
        output = s.arrangeCoins(n);
        verify(expect, output, 2);

        n = 10;
        expect = 4;
        output = s.arrangeCoins(n);
        verify(expect, output, 3);
    }

}
