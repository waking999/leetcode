package leetcode.success.array;

import leetcode.success.comm.Util;

public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
		if(nums==null) {
			return 0;
		}
		int numsLen=nums.length;
		int count=0;
		int ret=0;
		for(int i=0;i<numsLen;i++) {
			count = (nums[i] == 0) ? 0 : count + 1;
            ret = Math.max(ret, count);
		}
		
		return ret;
				
	}

	public static void main(String[] args) {
		MaxConsecutiveOnes s = new MaxConsecutiveOnes();

		int[] nums;
		int expect;
		int output;

		nums = new int[] { 1, 1, 0, 1, 1, 1 };
		expect = 3;
		output = s.findMaxConsecutiveOnes(nums);
		Util.verify(expect,output,1);
	}

}
