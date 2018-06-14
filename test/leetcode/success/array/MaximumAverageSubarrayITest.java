package leetcode.success.array;

import common.Util;
import org.junit.Test;

public class MaximumAverageSubarrayITest {

    @Test
    public void test1() {
        MaximumAverageSubarrayI s = new MaximumAverageSubarrayI();

        int[] nums;
        int k;
        double expect;
        double output;

        nums = new int[] { 1, 12, -5, -6, 50, 3 };
        k = 4;
        expect = 12.75;
        output = s.findMaxAverage(nums, k);
        Util.verify(expect, output, 1);

    }
}
