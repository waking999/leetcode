package leetcode.success.array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) {
            return false;
        }
        int numsLen = nums.length;
        if (numsLen < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numsLen; i++) {
            if (map.containsKey(nums[i])) {
                int pos = map.get(nums[i]);
                if (i - pos <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);

        }

        return false;
    }


}
