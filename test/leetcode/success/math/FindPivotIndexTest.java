package leetcode.success.math;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class FindPivotIndexTest {

    @Test
    public void test1() {
        FindPivotIndex s = new FindPivotIndex();

        int[] nums;
        int expect;
        int output;
        int seq = 0;

        nums = new int[]{1, 7, 3, 6, 5, 6};
        expect = 3;
        output = s.pivotIndex(nums);
        verify(expect, output, seq++);

        nums = new int[]{1, 2, 3};
        expect = -1;
        output = s.pivotIndex(nums);
        verify(expect, output, seq++);

        nums = new int[]{-1, -1, 0, 1, 1, 0};
        expect = 5;
        output = s.pivotIndex(nums);
        verify(expect, output, seq++);

    }

}
