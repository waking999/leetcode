package leetcode.success.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/majority-element-ii/description/
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * <p>
 * Note: The algorithm should run in linear time and in O(1) space.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 * <p>
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null) {
            return null;
        }
        int numsLen = nums.length;
        int compareNum = numsLen / 3;

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.compute(n, (k, v) -> (v == null) ? 1 : v + 1);
        }
        List<Integer> rtn = map.entrySet().stream().filter(x -> x.getValue() > compareNum).map(x -> x.getKey()).collect(Collectors.toList());

        return rtn;
    }
}
