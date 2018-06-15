package leetcode.success.array;

import org.junit.Test;

import static common.Util.verify;

public class MaximumSwapTest {
    @Test
    public void test1() {
        MaximumSwap s = new MaximumSwap();

        int num;
        int expect;
        int output;

        num = 2736;
        expect = 7236;
        output = s.maximumSwap(num);
        verify(expect, output, 1);

        num = 9973;
        expect = 9973;
        output = s.maximumSwap(num);
        verify(expect, output, 2);

        num = -7236;
        expect = -2736;
        output = s.maximumSwap(num);
        verify(expect, output, 3);

        num = 98368;
        expect = 98863;
        output = s.maximumSwap(num);
        verify(expect, output, 4);


        num = 87367;
        expect = 87763;
        output = s.maximumSwap(num);
        verify(expect, output, 5);
    }
}
