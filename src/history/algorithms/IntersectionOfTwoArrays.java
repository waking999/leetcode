package history.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> numList = new ArrayList<>();
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;

        Set<Integer> nums1Set = new HashSet<>(nums1Len);
        for (int aNums1 : nums1) {
            nums1Set.add(aNums1);
        }
        Set<Integer> nums2Set = new HashSet<>(nums2Len);
        for (int aNums2 : nums2) {
            nums2Set.add(aNums2);
        }

        for (int i : nums2Set) {
            if (nums1Set.contains(i)) {
                numList.add(i);
            }
        }

        int numListSize = numList.size();
        int[] nums = new int[numListSize];

        for (int i = 0; i < numListSize; i++) {
            nums[i] = numList.get(i);
        }


        return nums;
    }


}

