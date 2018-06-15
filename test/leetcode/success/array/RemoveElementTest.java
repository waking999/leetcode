package leetcode.success.array;

import org.junit.Test;

import static common.Util.verify;
import static common.Util.verifyUnsort;

public class RemoveElementTest {
    @Test
    public void test1() {
        RemoveElement s = new RemoveElement();
        int seq = 1;

        int[] nums = {3, 2, 2, 3};
        int value = 3;
        int[] expectNums = {2, 2};
        int expect = 2;

        int output = s.removeElement(nums, value);
        verify(expect, output, seq++);
        verifyUnsort(expectNums, nums, seq++);

        nums = new int[]{1, 2, 2, 3, 2, 4};
        value = 2;
        expectNums = new int[]{1, 3, 4};
        expect = 3;

        output = s.removeElement(nums, value);
        verify(expect, output, seq++);
        verifyUnsort(expectNums, nums, seq++);
    }
}
