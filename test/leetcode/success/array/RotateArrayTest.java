package leetcode.success.array;

import org.junit.Test;

import static common.Util.verifyUnsort;

public class RotateArrayTest {
    @Test
    public void test1() {
        RotateArray s = new RotateArray();

        int[] nums;
        int k;
        int[] expect;
        int seq = 1;

        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        k = 3;
        expect = new int[]{5, 6, 7, 1, 2, 3, 4};
        s.rotate(nums, k);
        verifyUnsort(expect, nums, seq++);


        nums = new int[]{1, 2};
        k = 1;
        expect = new int[]{2, 1};
        s.rotate(nums, k);
        verifyUnsort(expect, nums, seq++);

        nums = new int[]{1, 2};
        k = 3;
        expect = new int[]{2, 1};
        s.rotate(nums, k);
        verifyUnsort(expect, nums, seq++);
    }
}
