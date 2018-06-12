package leetcode.success.math;

import java.util.Arrays;

import leetcode.success.comm.Util;

public class MaximumProductOfThreeNumbers {
	public int maximumProduct(int[] nums) {
		if (nums == null) {
			return 0;
		}
		int numsLen = nums.length;
		if (numsLen <= 3) {
			int prd = 1;
			for (int i = 0; i < numsLen; i++) {
				prd *= nums[i];
			}
			return numsLen == 0 ? 0 : prd;
		} else {
			
			Arrays.sort(nums);
			int p=nums[0]*nums[1]*nums[numsLen-1];
			return Math.max(p, nums[numsLen-1]*nums[numsLen-2]*nums[numsLen-3]);
		}

	}

	public static void main(String[] args) {
		MaximumProductOfThreeNumbers s = new MaximumProductOfThreeNumbers();

		int[] nums;
		int expect;
		int output;

		nums = new int[] { 1, 2, 3 };
		expect = 6;
		output = s.maximumProduct(nums);
		Util.verifyUnsort(expect, output, 1);

		nums = new int[] { 1, 2, 3, 4 };
		expect = 24;
		output = s.maximumProduct(nums);
		Util.verifyUnsort(expect, output, 2);

		nums = new int[] { 7, 0, 6, 4, 9, 6 };
		expect = 378;
		output = s.maximumProduct(nums);
		Util.verifyUnsort(expect, output, 3);

		nums = new int[] { 2, 3, 4, 7, 0, 6, 4, 9, 6 };
		expect = 378;
		output = s.maximumProduct(nums);
		Util.verifyUnsort(expect, output, 4);
		
		nums = new int[] {-1,-2,1,2,3};
		expect = 6;
		output = s.maximumProduct(nums);
		Util.verifyUnsort(expect, output, 5);
		
		nums = new int[] {-4,-3,-2,-1,60};
		expect = 720;
		output = s.maximumProduct(nums);
		Util.verifyUnsort(expect, output, 6);
		
		
		nums = new int[] {-4,-3,-2,-2,-1};
		expect = -4;
		output = s.maximumProduct(nums);
		Util.verifyUnsort(expect, output, 7);
		
		nums = new int[] {-4,3,2,1,60};
		expect = 360;
		output = s.maximumProduct(nums);
		Util.verifyUnsort(expect, output, 8);
	}

}
