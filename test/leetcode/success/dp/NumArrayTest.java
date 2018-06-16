package leetcode.success.dp;

import org.junit.Test;

import static common.Util.verify;

public class NumArrayTest {
    @Test
    public void test1() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray na = new NumArray(nums);
        int seq = 1;

        int i = 0;
        int j = 2;
        int expect = 1;
        int s = na.sumRange(i, j);
        verify(expect, s, seq++);

        i = 2;
        j = 5;
        expect = -1;
        s = na.sumRange(i, j);
        verify(expect, s, seq++);

        i = 0;
        j = 5;
        expect = -3;
        s = na.sumRange(i, j);
        verify(expect, s, seq++);

    }
}
