package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verifySort;

public class NextGreaterElementITest {
    @Test
    public void test1() {
        NextGreaterElementI s = new NextGreaterElementI();

        int[] nums1;
        int[] nums2;
        int[] expect;
        int[] output;

        nums1 = new int[]{4, 1, 2};
        nums2 = new int[]{1, 3, 4, 2};
        expect = new int[]{-1, 3, -1};
        output = s.nextGreaterElement(nums1, nums2);
        verifySort(expect, output, 1);

        nums1 = new int[]{2, 4};
        nums2 = new int[]{1, 2, 3, 4};
        expect = new int[]{3, -1};
        output = s.nextGreaterElement(nums1, nums2);
        verifySort(expect, output, 2);
    }
}
