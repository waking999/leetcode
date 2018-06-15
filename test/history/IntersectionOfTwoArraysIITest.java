package history;

import history.algorithms.IntersectionOfTwoArraysII;
import org.junit.Test;

import static common.Util.verifyUnsort;

public class IntersectionOfTwoArraysIITest {

    @Test
    public void test1() {
        IntersectionOfTwoArraysII s = new IntersectionOfTwoArraysII();
        int[] nums1;
        int[] nums2;
        int[] expect;
        int[] output;
        int seq = 1;

        nums1 = new int[]{1, 2, 2, 1};
        nums2 = new int[]{2, 2};
        expect = new int[]{2, 2};
        output = s.intersect(nums1, nums2);
        verifyUnsort(expect, output, seq++);


        nums1 = new int[]{1, 2, 2, 3, 1, 3};
        nums2 = new int[]{2, 3, 2};
        expect = new int[]{2, 2, 3};
        output = s.intersect(nums1, nums2);
        verifyUnsort(expect, output, seq++);

    }
}
