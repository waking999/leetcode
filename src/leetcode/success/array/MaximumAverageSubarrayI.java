package leetcode.success.array;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        int numsLen = nums.length;
        if (numsLen == 0) {
            return 0;
        }

        if (numsLen <= k) {
            int sum = 0;
            int count = 0;
            for (int num : nums) {
                sum += num;
                count++;
            }
            return sum * 1.0 / count;
        } else {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
            double ret = sum;
            for (int i = k; i < numsLen; i++) {
                sum += nums[i] - nums[i - k];
                ret = Math.max(ret, sum);
            }
            return ret / k;
        }

    }


}
