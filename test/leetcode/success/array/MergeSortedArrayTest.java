package leetcode.success.array;

import org.junit.Test;

import static common.Util.verifyUnsort;

public class MergeSortedArrayTest {
    @Test
    public void test1() {
        MergeSortedArray s = new MergeSortedArray();

        int seq = 1;

        int[] nums1 = {1, 3, 5, 7, 9, 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1};
        int[] nums2 = {2, 4, 6, 8};
        int[] expect = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        s.merge(nums1, 6, nums2, 4);
        verifyUnsort(expect, nums2, seq++);

        nums1 = new int[]{0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        nums2 = new int[]{1};
        expect = new int[]{0, 1};
        s.merge(nums1, 1, nums2, 1);
        verifyUnsort(expect, nums2, seq++);

        nums1 = new int[]{0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        nums2 = new int[]{1};
        expect = new int[]{1};
        s.merge(nums1, 0, nums2, 1);
        verifyUnsort(expect, nums2, seq++);

    }
}
