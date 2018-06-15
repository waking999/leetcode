package leetcode.success.array;

import org.junit.Test;

import static common.Util.verifyUnsort;

public class TwoSumTest {
    @Test
    public void test1() {
        int seq = 1;

        int[] nums = {-3, 4, 3, 90};
        int target = 0;
        int[] expect = {0, 2};

        int[] output = new TwoSum().twoSum(nums, target);
        verifyUnsort(expect, output, seq++);
    }
}
