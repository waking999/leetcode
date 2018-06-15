package leetcode.success.array;

import org.junit.Test;

import static common.Util.verify;

public class FindMinimumInRotatedSortedArrayTest {
    @Test
    public void test1() {

        FindMinimumInRotatedSortedArray s = new FindMinimumInRotatedSortedArray();

        int[] nums;
        int expect;
        int output;
        int seq = 1;

        nums = new int[]{0, 1, 2, 4, 5, 6, 7};
        expect = 0;
        output = s.findMin(nums);
        verify(expect, output, seq++);

        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        expect = 0;
        output = s.findMin(nums);
        verify(expect, output, seq++);

        nums = new int[]{3, 1, 2};
        expect = 1;
        output = s.findMin(nums);
        verify(expect, output, seq++);
    }
}
