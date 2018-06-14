package leetcode.success.array;

import org.junit.Test;

public class RemoveDuplicatesFromSortedArrayTest {
    @Test
    public void test1() {
        RemoveDuplicatesFromSortedArray s = new RemoveDuplicatesFromSortedArray();

        int[] nums = { 2, 2, 3, 3 };
        int[] expectNums = { 2, 3 };
        int expect = 2;

        int output = s.removeDuplicates(nums);
        assert (output == expect) : "1.wrong";
        for (int i = 0; i < output; i++) {
            assert (nums[i] == expectNums[i]) : "1.wrong";
        }

        nums = new int[] { 1, 2, 2, 2, 3, 4 };

        expectNums = new int[] { 1, 2, 3, 4 };
        expect = 4;

        output = s.removeDuplicates(nums);
        assert (output == expect) : "2.wrong";
        for (int i = 0; i < output; i++) {
            assert (nums[i] == expectNums[i]) : "2.wrong";
        }

        System.out.println("Finish");

    }
}
