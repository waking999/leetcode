package history.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {

        int nums1Len = nums1.length;
        int nums2Len = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> numList = new ArrayList<>();
        int i = 0;
        int j = 0;
        for (; i < nums1Len && j < nums2Len; ) {
            if (nums1[i] < nums2[j]) {
                i++;

            } else if (nums2[j] < nums1[i]) {
                j++;
            } else {
                numList.add(nums1[i]);
                i++;
                j++;
            }
        }

        int numListSize = numList.size();
        int[] nums = new int[numListSize];

        for (int k = 0; k < numListSize; k++) {
            nums[k] = numList.get(k);
        }

        return nums;
    }



}
