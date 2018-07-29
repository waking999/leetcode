package leetcode.success.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/continuous-subarray-sum/description/
 * <p>
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.
 * <p>
 * Example 1:
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 * Example 2:
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 * Note:
 * The length of the array won't exceed 10,000.
 * You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */
public class ContinuousSubarraySum {


    private boolean satisfy(int sum,int k){
        if(k==0){
            return sum==k;
        }else{
            return sum % k == 0;
        }
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int numsLen = nums.length;

        int[] sums = new int[numsLen];
        sums[0] = nums[0];
        for (int i = 1; i < numsLen; i++) {
            sums[i] = sums[i - 1]+nums[i];
            boolean flag=satisfy(sums[i],k);

            if(flag){
                return true;
            }
        }

        for (int start = 0; start < numsLen - 1; start++) {
            int[] tmpSum = Arrays.copyOfRange(sums, start, numsLen);
            for (int i = 2; i < (numsLen - start); i++) {
                tmpSum[i]=tmpSum[i]-tmpSum[0];
                boolean flag=satisfy(tmpSum[i],k);

                if(flag){
                    return true;
                }
            }
        }


        return false;
    }
}
