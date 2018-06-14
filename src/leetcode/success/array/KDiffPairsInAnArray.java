package leetcode.success.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
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
        int answer = 0;
        for (Integer i : keySet) {
            if (k == 0 && map.get(i) > 1) {
                answer++;
            }
            if (k > 0 && map.containsKey(i + k)) {
                answer++;
            }
        }

        return answer;
    }


}
