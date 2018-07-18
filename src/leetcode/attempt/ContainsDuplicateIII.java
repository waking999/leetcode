package leetcode.attempt;

import java.util.TreeSet;

public class ContainsDuplicateIII {
    /**
     * Given an digits of integers, find out whether there are two distinct indices i
     * and j in the digits such that the absolute difference between nums[i] and
     * nums[j] is at most t and the absolute difference between i and j is at most
     * k.
     *
     * @param nums an digits of integers
     * @param k    |i-j|<=k
     * @param t    |nums[i]-nums[j]|<=t
     * @return true if condition satisfied; false otherwise
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Long> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Long floor = values.floor((long) nums[ind] + t);
            final Long ceil = values.ceiling((long) nums[ind] - t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add((long) nums[ind]);
            if (ind >= k) {
                values.remove((long) nums[ind - k]);
            }
        }

        return false;
    }


}
