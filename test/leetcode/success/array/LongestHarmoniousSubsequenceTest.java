package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

public class LongestHarmoniousSubsequenceTest {
    @Test
    public void test1() {
        LongestHarmoniousSubsequence s = new LongestHarmoniousSubsequence();

        int[] nums;
        int expect;
        int output;

        nums = new int[]{1, 3, 2, 2, 5, 2, 3, 7};
        expect = 5;
        output = s.findLHS(nums);
        Util.verify(expect, output, 1);
    }
}
