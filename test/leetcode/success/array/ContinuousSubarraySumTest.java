package leetcode.success.array;

import common.Util;
import leetcode.success.array.ContinuousSubarraySum;
import org.junit.jupiter.api.Test;

public class ContinuousSubarraySumTest {
    @Test
    public void test1() {
        ContinuousSubarraySum s = new ContinuousSubarraySum();

        int[] nums;
        int k;
        boolean expect;
        boolean output;
        int seq = 1;

        nums = new int[]{23, 2, 4, 6, 6};
        k = 6;
        expect = true;
        output = s.checkSubarraySum(nums, k);
        Util.verify(expect, output, seq++);

        nums = new int[]{23, 2, 6, 4, 7};
        k = 6;
        expect = true;
        output = s.checkSubarraySum(nums, k);
        Util.verify(expect, output, seq++);

        nums = new int[]{23, 2};
        k = 6;
        expect = false;
        output = s.checkSubarraySum(nums, k);
        Util.verify(expect, output, seq++);

        nums = new int[]{23, 2, 6, 4, 7};
        k = 0;
        expect = false;
        output = s.checkSubarraySum(nums, k);
        Util.verify(expect, output, seq++);
    }
}
