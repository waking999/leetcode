package leetcode.success.array;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * <p>
 * Formally the function should:
 * <p>
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: true
 * Example 2:
 * <p>
 * Input: [5,4,3,2,1]
 * Output: false
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null) {
            return false;
        }
        int numsLen = nums.length;
        if (numsLen <= 2) {
            return false;
        }
        int i = 0;
        int j = 1;
        int k = 2;
        int preI = i;
        int preJ=j;
        while (i < numsLen - 2) {
            while(j<numsLen-1) {
                while (k < numsLen) {
                    preI = i;
                    preJ=j;
                    if (nums[i] < nums[j] && nums[j] < nums[k]) {
                        return true;
                    } else if ((nums[i] < nums[j] && nums[k] < nums[j]) || (nums[i] < nums[j] && nums[j] == nums[k])) {
                        k++;
                    } else if ((nums[i] > nums[j] && nums[j] < nums[k]) || (nums[i] == nums[j] && nums[j] < nums[k]) || (nums[i] == nums[k] && nums[i] > nums[j])) {

                        i = j;
                        j = k;
                        k = j + 1;
                    } else if ((nums[i] > nums[j] && nums[j] > nums[k]) || (nums[i] == nums[j] && nums[j] == nums[k]) || (nums[i] == nums[j] && nums[j] > nums[k])|| (nums[i] > nums[j] && nums[j] == nums[k])) {

                        i = k;
                        j = i + 1;
                        k = i + 2;
                    }
                }
                i=preI;
                j=++preJ;
                k=j+1;
            }
            i = ++preI;
            j = i + 1;
            k = i + 2;
        }

        return false;

    }
}
