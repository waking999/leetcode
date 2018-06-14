package leetcode.success.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int numsLen = nums.length;
        if (numsLen == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        Set<Integer> keySet = map.keySet();
        int max = 0;
        for (int key : keySet) {
            if (map.containsKey(key + 1)) {
                max = Math.max(max, map.get(key) + map.get(key + 1));
            }
        }

        return max;
    }


}
