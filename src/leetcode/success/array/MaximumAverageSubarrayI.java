package leetcode.success.array;

import leetcode.success.comm.Util;

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
			for (int i = 0; i < numsLen; i++) {
				sum += nums[i];
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
			return ret/k;
		}

	}

	public static void main(String[] args) {
		MaximumAverageSubarrayI s = new MaximumAverageSubarrayI();

		int[] nums;
		int k;
		double expect;
		double output;

		nums = new int[] { 1, 12, -5, -6, 50, 3 };
		k = 4;
		expect = 12.75;
		output = s.findMaxAverage(nums, k);
		Util.verify(expect, output, 1);
 
	}

}
