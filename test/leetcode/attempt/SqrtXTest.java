package leetcode.attempt;

import org.junit.jupiter.api.Test;

import static common.Util.verify;


public class SqrtXTest {
    @Test
    public void test1() {
        SqrtX s = new SqrtX();

        int x;
        int expect;
        int output;
        int seq = 0;

        x = 1;
        expect = (int) Math.sqrt(x);
        output = s.mySqrt(x);
        verify(expect, output, seq++);

        x = 2;
        expect = (int) Math.sqrt(x);
        output = s.mySqrt(x);
        verify(expect, output, seq++);

        x = 4;
        expect = (int) Math.sqrt(x);
        output = s.mySqrt(x);
        verify(expect, output, seq++);

        x = 9;
        expect = (int) Math.sqrt(x);
        output = s.mySqrt(x);
        verify(expect, output, seq++);

        x = 2147395599;
        expect = (int) Math.sqrt(x);
        output = s.mySqrt(x);
        verify(expect, output, seq++);

        x = 2147483647;
        expect = (int) Math.sqrt(x);
        output = s.mySqrt(x);
        verify(expect, output, seq++);

    }

}
