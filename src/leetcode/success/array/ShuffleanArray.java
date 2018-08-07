package leetcode.success.array;

import java.util.Random;

/**
 * https://leetcode.com/problems/shuffle-an-array/description/
 * Shuffle a set of numbers without duplicates.
 * <p>
 * Example:
 * <p>
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * <p>
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * <p>
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 */
public class ShuffleanArray {
    private int[] nums;
    private int[] shuffledNums;
    private int shuffleNumPos;
    private Random r;

    public ShuffleanArray(int[] nums) {
        this.nums = nums;
        shuffledNums = new int[nums.length];
        r = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        if (nums.length == 0) {
            return nums;
        }

        shuffleNumPos = 0;
        shuffle(0, nums.length - 1);
        return shuffledNums;
    }

    private void shuffle(int low, int high) {

        int p = r.nextInt(high + 1 - low) + low;
        shuffledNums[shuffleNumPos++] = nums[p];
        if (low == high) {
            return;
        }
        if (p > low) {
            shuffle(low, p - 1);
        }
        if (p < high) {
            shuffle(p + 1, high);
        }

    }
}
