package leetcode.success.array;

import org.junit.Test;

public class RemoveDuplicatesFromSortedArrayIITest {
    @Test
    public void test1() {
        RemoveDuplicatesFromSortedArrayII s = new RemoveDuplicatesFromSortedArrayII();

        int[] nums;
        int[] expectNums;
        int expect;
        int output;

        nums = new int[]{1, 1, 1, 2, 2, 3};
        expectNums = new int[]{1, 1, 2, 2, 3};
        expect = 5;

        output = s.removeDuplicates(nums);
        assert (output == expect) : "1.wrong";
        for (int i = 0; i < output; i++) {
            assert (nums[i] == expectNums[i]) : "1.wrong";
        }

        System.out.println("Finish");
    }

}
