package leetcode.attempt;

import leetcode.success.comm.Util;
import org.junit.Test;

public class MaximumSubarray {

	public int maxSubArray(int[] nums) {
		int maxSum = nums[0];
		int maxSoFar = Math.max(0, nums[0]); // maximum ending at i - 1
		for (int i = 1; i < nums.length; ++i) {
			maxSoFar += nums[i];
			maxSum = Math.max(maxSum, maxSoFar);
			if (maxSoFar < 0)
				maxSoFar = 0; // empty array is better
		}
		return maxSum;
	}


	@Test
	public void test1() {
		MaximumSubarray s = new MaximumSubarray();

		int[] nums;
		int expect;
		int output;
		int seq = 0;

		nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		expect = 6;
		output = s.maxSubArray(nums);
		Util.verify(expect, output, seq++);

		nums = new int[] { -2, 1 };
		expect = 1;
		output = s.maxSubArray(nums);
		Util.verify(expect, output, seq++);

		nums = new int[] { 1 };
		expect = 1;
		output = s.maxSubArray(nums);
		Util.verify(expect, output, seq++);

		nums = new int[] { -1 };
		expect = -1;
		output = s.maxSubArray(nums);
		Util.verify(expect, output, seq++);

		nums = new int[] { -2, -1 };
		expect = -1;
		output = s.maxSubArray(nums);
		Util.verify(expect, output, seq++);

	}

}
