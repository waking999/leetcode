package leetcode.attempt;

import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.TreeSet;

public class ContainsDuplicateIII {
    /**
     * Given an array of integers, find out whether there are two distinct indices i
     * and j in the array such that the absolute difference between nums[i] and
     * nums[j] is at most t and the absolute difference between i and j is at most
     * k.
     *
     * @param nums
     * @param k    |i-j|<=k
     * @param t    |nums[i]-nums[j]|<=t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Long> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Long floor = values.floor((long)nums[ind] + t);
            final Long ceil = values.ceiling((long)nums[ind] - t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add((long)nums[ind]);
            if (ind >= k) {
                values.remove((long)nums[ind - k]);
            }
        }

        return false;
    }

    @Test
    public void testcontainsNearbyAlmostDuplicate() {
        ContainsDuplicateIII s = new ContainsDuplicateIII();

        int[] nums;
        int k;
        int t;
        boolean expect;
        boolean output;
        int seq = 0;


        nums = new int[]{1, 2, 3, 1};
        k = 3;
        t = 0;
        expect = true;
        output = s.containsNearbyAlmostDuplicate(nums, k, t);
        Util.verify(expect, output, seq++);

        nums = new int[]{1, 0, 1, 1};
        k = 1;
        t = 2;
        expect = true;
        output = s.containsNearbyAlmostDuplicate(nums, k, t);
        Util.verify(expect, output, seq++);

        nums = new int[]{1, 5, 9, 1, 5, 9};
        k = 2;
        t = 3;
        expect = false;
        output = s.containsNearbyAlmostDuplicate(nums, k, t);
        Util.verify(expect, output, seq++);

        nums = new int[]{-2147483648, -2147483647};
        k = 3;
        t = 3;
        expect = true;
        output = s.containsNearbyAlmostDuplicate(nums, k, t);
        Util.verify(expect, output, seq++);


    }
}
