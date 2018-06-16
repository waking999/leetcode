package leetcode.success.math;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class SumOfSquareNumbersTest {
    @Test
    public void test1() {
        SumOfSquareNumbers s = new SumOfSquareNumbers();

        int c;
        boolean expect;
        boolean output;

        c = 5;
        expect = true;
        output = s.judgeSquareSum(c);
        verify(expect, output, 1);
    }
}
