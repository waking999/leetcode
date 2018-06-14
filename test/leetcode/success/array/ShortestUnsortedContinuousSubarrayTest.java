package leetcode.success.array;

import org.junit.Test;

import static leetcode.success.comm.Util.verify;

public class ShortestUnsortedContinuousSubarrayTest {
    @Test
    public void test1() {
        ShortestUnsortedContinuousSubarray s = new ShortestUnsortedContinuousSubarray();

        int[] nums;
        int expect;
        int output;


        nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        expect = 5;
        output = s.findUnsortedSubarray(nums);
        verify(expect, output, 1);


        nums = new int[]{1, 2, 3, 4};
        expect = 0;
        output = s.findUnsortedSubarray(nums);
        verify(expect, output, 2);

        nums = new int[]{1, 3, 2, 2, 2};
        expect = 4;
        output = s.findUnsortedSubarray(nums);
        verify(expect, output, 3);

        nums = new int[]{1, 2, 3, 3, 3};
        expect = 0;
        output = s.findUnsortedSubarray(nums);
        verify(expect, output, 4);
    }
}
