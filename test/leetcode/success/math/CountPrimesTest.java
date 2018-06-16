package leetcode.success.math;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class CountPrimesTest {
    @Test
    public void test1() {
        CountPrimes s = new CountPrimes();

        int n;
        int expect;
        int output;

        n = 4;
        expect = 2;
        output = s.countPrimes(n);
        verify(expect, output, 1);

        n = 2;
        expect = 0;
        output = s.countPrimes(n);
        verify(expect, output, 1);

        n = 3;
        expect = 1;
        output = s.countPrimes(n);
        verify(expect, output, 1);

    }
}
