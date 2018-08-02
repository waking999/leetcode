package leetcode.success.array;

/**
 * https://leetcode.com/problems/132-pattern/description/
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
 * <p>
 * Note: n will be less than 15,000.
 * <p>
 * Example 1:
 * Input: [1, 2, 3, 4]
 * <p>
 * Output: False
 * <p>
 * Explanation: There is no 132 pattern in the sequence.
 * Example 2:
 * Input: [3, 1, 4, 2]
 * <p>
 * Output: True
 * <p>
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * Example 3:
 * Input: [-1, 3, 2, 0]
 * <p>
 * Output: True
 * <p>
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */
public class OneTwoThreePattern {
    public boolean find132pattern(int[] nums) {
        if (nums == null) {
            return false;
        }
        int numsLen = nums.length;
        if (numsLen < 3) {
            return false;
        }


        int i = 0;
        int j = 1;
        int k = 2;
        while (i<=numsLen-3) {

            if (nums[i] < nums[k] && nums[k] < nums[j]) {
                return true;
            }
            if(nums[i]>nums[j]&&nums[i]>nums[k]){
                //ai is the biggest
                if(nums[j]<nums[k]){
                    i++;
                    j++;
                    k++;
                }else{
                    i=k;
                    j=k+1;
                    k=k+2;
                }
            }else if(nums[j]>nums[i]&&nums[j]>nums[k]){
                //aj is the biggest
                //if ai<ak, it return true already
                //so ai must > ak
                k++;
            }else if(nums[k]>nums[i]&&nums[k]>nums[j]){
                //ak is the biggest
                if(nums[i]<nums[j]){
                    k++;
                }else{
                    i++;
                    j++;
                    k++;
                }
            }

            if(k>=numsLen){
                i++;
                j=i+1;
                k=i+2;
            }
        }


        return false;
    }


}
