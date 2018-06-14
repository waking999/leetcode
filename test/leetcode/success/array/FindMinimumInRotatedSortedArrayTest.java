package leetcode.success.array;

import common.Util;
import org.junit.Test;

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
        Util.verify(expect, output, seq++);

        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        expect = 0;
        output = s.findMin(nums);
        Util.verify(expect, output, seq++);

        nums = new int[]{3, 1, 2};
        expect = 1;
        output = s.findMin(nums);
        Util.verify(expect, output, seq++);
    }
}
