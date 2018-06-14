package leetcode.success.array;

import java.util.Arrays;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] ret = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int pos = locate(nums2, nums1[i]);
            int[] subNums2 = Arrays.copyOfRange(nums2, pos + 1, nums2.length);
            ret[i] = nextGreater(subNums2, nums1[i]);
        }
        return ret;
    }

    private int locate(int[] nums2, int val) {
        for (int i = 0; i < nums2.length; i++) {
            if (val == nums2[i]) {
                return i;
            }
        }
        return -1;
    }

    private int nextGreater(int[] subNums2, int val) {
        for (int aSubNums2 : subNums2) {
            if (aSubNums2 > val) {
                return aSubNums2;
            }
        }
        return -1;
    }


}
