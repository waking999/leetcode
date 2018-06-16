package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class SearchInsertPositionTest {
    @Test
    public void test1() {
        SearchInsertPosition s = new SearchInsertPosition();

        int[] nums;
        int target;
        int expect;
        int output;
        int seq = 1;

        nums = new int[]{1, 3, 5, 6};
        target = 5;
        expect = 2;
        output = s.searchInsert(nums, target);
        verify(expect, output, seq++);

        nums = new int[]{1, 3, 5, 6};
        target = 2;
        expect = 1;
        output = s.searchInsert(nums, target);
        verify(expect, output, seq++);


        nums = new int[]{1, 3, 5, 6};
        target = 7;
        expect = 4;
        output = s.searchInsert(nums, target);
        verify(expect, output, seq++);


        nums = new int[]{1, 3, 5, 6};
        target = 0;
        expect = 0;
        output = s.searchInsert(nums, target);
        verify(expect, output, seq++);

    }
}
