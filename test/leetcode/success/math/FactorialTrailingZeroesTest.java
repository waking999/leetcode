package leetcode.success.math;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class FactorialTrailingZeroesTest {
    @Test
    public void test1() {
        FactorialTrailingZeroes s = new FactorialTrailingZeroes();

        int n;
        int expect;
        int output;

        n = 5;
        expect = 1;
        output = s.trailingZeroes(n);
        verify(expect, output, 1);

        n = 11;
        expect = 2;
        output = s.trailingZeroes(n);
        verify(expect, output, 2);

        n = 28;
        expect = 6;
        output = s.trailingZeroes(n);
        verify(expect, output, 3);

        n = 1808548329;
        expect = 452137076;
        output = s.trailingZeroes(n);
        verify(expect, output, 4);


    }

}
