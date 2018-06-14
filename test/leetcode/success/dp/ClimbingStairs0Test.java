package leetcode.success.dp;

import common.Util;
import org.junit.Test;

public class ClimbingStairs0Test {
    @Test
    public void testclimbStairs() {
        leetcode.success.dp.ClimbingStairs s=new leetcode.success.dp.ClimbingStairs();

        int n;
        int expect;
        int output;
        int seq=0;

        n=3;
        expect=3;
        output=s.climbStairs(n);
        Util.verify(expect, output, seq++);

        n=4;
        expect=5;
        output=s.climbStairs(n);
        Util.verify(expect, output, seq++);

        n=5;
        expect=8;
        output=s.climbStairs(n);
        Util.verify(expect, output, seq++);

    }
}
