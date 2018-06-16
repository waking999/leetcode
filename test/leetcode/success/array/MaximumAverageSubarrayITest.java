package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class MaximumAverageSubarrayITest {

    @Test
    public void test1() {
        MaximumAverageSubarrayI s = new MaximumAverageSubarrayI();

        int[] nums;
        int k;
        double expect;
        double output;

        nums = new int[]{1, 12, -5, -6, 50, 3};
        k = 4;
        expect = 12.75;
        output = s.findMaxAverage(nums, k);
        verify(expect, output, 1);

    }
}
