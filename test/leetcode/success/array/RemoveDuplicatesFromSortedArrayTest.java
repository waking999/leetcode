package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verify;
import static common.Util.verifyUnsort;

public class RemoveDuplicatesFromSortedArrayTest {
    @Test
    public void test1() {
        RemoveDuplicatesFromSortedArray s = new RemoveDuplicatesFromSortedArray();
        int seq = 1;

        int[] nums = {2, 2, 3, 3};
        int[] expectNums = {2, 3};
        int expect = 2;

        int output = s.removeDuplicates(nums);
        verify(expect, output, seq++);
        verifyUnsort(expectNums, nums, seq++);

        nums = new int[]{1, 2, 2, 2, 3, 4};
        expectNums = new int[]{1, 2, 3, 4};
        expect = 4;
        output = s.removeDuplicates(nums);
        verify(expect, output, seq++);
        verifyUnsort(expectNums, nums, seq++);

    }
}
