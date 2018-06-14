package leetcode.success.array;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int numsLen = nums.length;
        if (numsLen <= 1) {
            return 0;
        }

        int[] nums1 = Arrays.copyOf(nums, numsLen);
        Arrays.sort(nums1);

        int start = numsLen - 1;
        for (int i = 0; i < numsLen; i++) {
            if (nums1[i] != nums[i]) {
                start = i;
                break;
            }
        }
        int end = 0;
        for (int i = numsLen - 1; i >= 0; i--) {
            if (nums1[i] != nums[i]) {
                end = i;
                break;
            }
        }
        if (start > end) {
            return 0;
        }
        return end - start + 1;
    }


}
