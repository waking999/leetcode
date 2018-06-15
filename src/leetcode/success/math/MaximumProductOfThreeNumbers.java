package leetcode.success.math;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
	public int maximumProduct(int[] nums) {
		if (nums == null) {
			return 0;
		}
		int numsLen = nums.length;
		if (numsLen <= 3) {
			int prd = 1;
			for (int num : nums) {
				prd *= num;
			}
			return numsLen == 0 ? 0 : prd;
		} else {
			
			Arrays.sort(nums);
			int p=nums[0]*nums[1]*nums[numsLen-1];
			return Math.max(p, nums[numsLen-1]*nums[numsLen-2]*nums[numsLen-3]);
		}

	}


}
