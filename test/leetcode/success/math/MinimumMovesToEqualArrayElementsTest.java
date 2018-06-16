package leetcode.success.math;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class MinimumMovesToEqualArrayElementsTest {
    @Test
    public void test1() {
        MinimumMovesToEqualArrayElements s = new MinimumMovesToEqualArrayElements();

        int[] nums;
        int expect;
        int output;

        nums = new int[]{1, 2, 3};
        expect = 3;
        output = s.minMoves(nums);
        verify(expect, output, 1);

    }
}
