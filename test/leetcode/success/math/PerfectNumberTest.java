package leetcode.success.math;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class PerfectNumberTest {
    @Test
    public void test1() {
        PerfectNumber s = new PerfectNumber();

        int num;
        boolean expect;
        boolean output;

        num = 28;
        expect = true;
        output = s.checkPerfectNumber(num);
        verify(expect, output, 1);


    }
}
