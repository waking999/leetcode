package history;

import history.algorithms.IntersectionOfTwoArrays;
import leetcode.success.comm.Util;
import org.junit.Test;

public class IntersectionOfTwoArraysTest {

    @Test
    public void test1() {
        IntersectionOfTwoArrays s = new IntersectionOfTwoArrays();
        int[] nums1;
        int[] nums2;
        int[] expect;
        int[] output;
        int seq = 1;

        nums1 = new int[]{1, 2, 2, 1};
        nums2 = new int[]{2, 2};
        expect = new int[]{2};
        output = s.intersection(nums1, nums2);
        Util.verifyUnsort(expect, output, seq++);


    }
}
