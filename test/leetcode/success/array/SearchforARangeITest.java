package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verifyUnsort;

public class SearchforARangeITest {
    @Test
    public void testsearchRange() {
        SearchforARangeI s = new SearchforARangeI();

        int[] nums;
        int target;
        int[] expect;
        int[] output;
        int seq = 0;


        nums = new int[]{5, 7, 7, 8, 8, 10};
        target = 8;
        expect = new int[]{3, 4};
        output = s.searchRange(nums, target);
        verifyUnsort(expect, output, seq++);

        nums = new int[]{5, 7, 7, 8, 8, 10};
        target = 6;
        expect = new int[]{-1, -1};
        output = s.searchRange(nums, target);
        verifyUnsort(expect, output, seq++);

    }
}
