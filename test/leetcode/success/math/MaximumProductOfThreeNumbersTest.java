package leetcode.success.math;

import org.junit.Test;

import static common.Util.verify;

public class MaximumProductOfThreeNumbersTest {
    @Test
    public void test1() {
        MaximumProductOfThreeNumbers s = new MaximumProductOfThreeNumbers();

        int[] nums;
        int expect;
        int output;

        nums = new int[]{1, 2, 3};
        expect = 6;
        output = s.maximumProduct(nums);
        verify(expect, output, 1);

        nums = new int[]{1, 2, 3, 4};
        expect = 24;
        output = s.maximumProduct(nums);
        verify(expect, output, 2);

        nums = new int[]{7, 0, 6, 4, 9, 6};
        expect = 378;
        output = s.maximumProduct(nums);
        verify(expect, output, 3);

        nums = new int[]{2, 3, 4, 7, 0, 6, 4, 9, 6};
        expect = 378;
        output = s.maximumProduct(nums);
        verify(expect, output, 4);

        nums = new int[]{-1, -2, 1, 2, 3};
        expect = 6;
        output = s.maximumProduct(nums);
        verify(expect, output, 5);

        nums = new int[]{-4, -3, -2, -1, 60};
        expect = 720;
        output = s.maximumProduct(nums);
        verify(expect, output, 6);


        nums = new int[]{-4, -3, -2, -2, -1};
        expect = -4;
        output = s.maximumProduct(nums);
        verify(expect, output, 7);

        nums = new int[]{-4, 3, 2, 1, 60};
        expect = 360;
        output = s.maximumProduct(nums);
        verify(expect, output, 8);
    }

}
