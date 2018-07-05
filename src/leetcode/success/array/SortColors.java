package leetcode.success.array;

/**
 * https://leetcode.com/problems/sort-colors/description/
 * <p>
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Example:
 * <p>
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 * <p>
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int numsLen = nums.length;
        int pl = 0;
        int p = 0;
        int pr = numsLen - 1;
        while (p <= pr) {
            if (nums[p] == 0) {
                if (p != pl) {
                    swap(nums, p, pl);
                }
                pl++;
                p++;
            } else if (nums[p] == 1) {
                p++;
            } else {
                if (p != pr) {
                    swap(nums, p, pr);
                }
                pr--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
