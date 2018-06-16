package leetcode.success.other;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class ReverseIntegerTest {
    @Test
    public void test1() {
        ReverseInteger s = new ReverseInteger();

        int x;
        int expect;
        int output;
        int seq = 0;

        x = 123;
        expect = 321;
        output = s.reverse(x);
        verify(expect, output, seq++);

        x = -123;
        expect = -321;
        output = s.reverse(x);
        verify(expect, output, seq++);

        x = 1534236469;
        expect = 0;
        output = s.reverse(x);
        verify(expect, output, seq++);

    }
}
