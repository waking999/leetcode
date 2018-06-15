package leetcode.success.dp;

import org.junit.Test;

import static common.Util.verify;

public class ClimbingStairs0Test {
    @Test
    public void testclimbStairs() {
        ClimbingStairs0 s = new ClimbingStairs0();

        int n;
        int expect;
        int output;
        int seq = 0;

        n = 3;
        expect = 3;
        output = s.climbStairs(n);
        verify(expect, output, seq++);

        n = 4;
        expect = 5;
        output = s.climbStairs(n);
        verify(expect, output, seq++);

        n = 5;
        expect = 8;
        output = s.climbStairs(n);
        verify(expect, output, seq++);

    }
}
