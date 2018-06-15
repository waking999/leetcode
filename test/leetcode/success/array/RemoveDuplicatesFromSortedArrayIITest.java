package leetcode.success.array;

import org.junit.Test;

import static common.Util.verify;
import static common.Util.verifyUnsort;

public class RemoveDuplicatesFromSortedArrayIITest {
    @Test
    public void test1() {
        RemoveDuplicatesFromSortedArrayII s = new RemoveDuplicatesFromSortedArrayII();

        int[] nums;
        int[] expectNums;
        int expect;
        int output;
        int seq = 1;

        nums = new int[]{1, 1, 1, 2, 2, 3};
        expectNums = new int[]{1, 1, 2, 2, 3};
        expect = 5;
        output = s.removeDuplicates(nums);
        verify(expect, output, seq++);
        verifyUnsort(expectNums, nums, seq++);


    }

}
