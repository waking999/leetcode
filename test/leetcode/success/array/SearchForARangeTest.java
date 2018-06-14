package leetcode.success.array;

import org.junit.Test;

import static common.Util.verifyUnsort;

public class SearchForARangeTest {
    @Test
    public void test1() {
        SearchForARange s = new SearchForARange();

        int[] nums;
        int target;
        int[] expect;
        int[] output;
        int seq = 1;

        nums = new int[]{5, 7, 7, 8, 8, 10};
        target = 8;
        expect = new int[]{3, 4};
        output = s.searchRange(nums, target);
        verifyUnsort(expect, output, seq++);
    }
}
