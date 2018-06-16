package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class MaxConsecutiveOnesTest {
    @Test
    public void test1() {
        MaxConsecutiveOnes s = new MaxConsecutiveOnes();

        int[] nums;
        int expect;
        int output;

        nums = new int[]{1, 1, 0, 1, 1, 1};
        expect = 3;
        output = s.findMaxConsecutiveOnes(nums);
        verify(expect, output, 1);
    }

}
