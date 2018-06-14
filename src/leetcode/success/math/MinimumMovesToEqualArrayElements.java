package leetcode.success.math;

import leetcode.success.comm.Util;

public class MinimumMovesToEqualArrayElements {
	public int minMoves(int[] nums) {
		int numsLen=nums.length;
		int sum=0;
		int min=Integer.MAX_VALUE;
		for (int num : nums) {
			sum += num;
			if (num <= min) {
				min = num;
			}
		}
		
		return sum-min*numsLen;
	}
	

	public static void main(String[] args) {
		MinimumMovesToEqualArrayElements s=new MinimumMovesToEqualArrayElements();
		
		int[] nums;
		int expect;
		int output;
		
		nums=new int[]{1,2,3};
		expect=3;
		output=s.minMoves(nums);
		Util.verify(expect, output, 1);

	}

}
