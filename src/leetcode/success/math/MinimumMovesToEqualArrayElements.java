package leetcode.success.math;

import leetcode.success.comm.Util;

public class MinimumMovesToEqualArrayElements {
	public int minMoves(int[] nums) {
		int numsLen=nums.length;
		int sum=0;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<numsLen;i++){
			sum+=nums[i];
			if(nums[i]<=min){
				min=nums[i];
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
		Util.verifyUnsort(expect, output, 1);

	}

}
