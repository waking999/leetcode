package leetcode.success.array;

import java.util.*;

/**
 * https://leetcode.com/problems/random-pick-index/description/
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
 * <p>
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 * <p>
 * Example:
 * <p>
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 * <p>
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 */
public class RandomPickIndex {
    private Map<Integer, List<Integer>> map;
    private Random rand;

    public RandomPickIndex(int[] nums) {
        map = new HashMap<>();
        int numsLen = nums.length;
        for (int i = 0; i < numsLen; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> l = map.get(nums[i]);
                l.add(i);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(nums[i], l);
            }
        }

        rand = new Random();
    }

    public int pick(int target) {
        List<Integer> l = map.get(target);
        int lLen = l.size();


        int n = rand.nextInt(lLen);

        return l.get(n);
    }
}
