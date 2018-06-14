package leetcode.attempt;

import leetcode.success.comm.Util;
import org.junit.Test;

public class MaximumSubarrayTest {
    @Test
    public void test1() {
        MaximumSubarray s = new MaximumSubarray();

        int[] nums;
        int expect;
        int output;
        int seq = 0;

        nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        expect = 6;
        output = s.maxSubArray(nums);
        Util.verify(expect, output, seq++);

        nums = new int[]{-2, 1};
        expect = 1;
        output = s.maxSubArray(nums);
        Util.verify(expect, output, seq++);

        nums = new int[]{1};
        expect = 1;
        output = s.maxSubArray(nums);
        Util.verify(expect, output, seq++);

        nums = new int[]{-1};
        expect = -1;
        output = s.maxSubArray(nums);
        Util.verify(expect, output, seq++);

        nums = new int[]{-2, -1};
        expect = -1;
        output = s.maxSubArray(nums);
        Util.verify(expect, output, seq++);

    }
}