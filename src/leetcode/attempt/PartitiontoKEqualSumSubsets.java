package leetcode.attempt;

import leetcode.success.comm.Util;
import org.junit.Test;

public class PartitiontoKEqualSumSubsets {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		if(nums==null) {
			return false;
		}
		int numsLen=nums.length;
		if(Math.pow(2, numsLen)<k) {
			return false;
		}
		
		int sum=0;
		for(int num:nums) {
			sum+=num;
		}
		if(sum%k!=0) {
			return false;
		}
		int subSum=sum/k;
		
		
		
		
		return false;
	}




	@Test
	public void test1() {
		PartitiontoKEqualSumSubsets s = new PartitiontoKEqualSumSubsets();

		int[] nums;
		int k;
		boolean expect;
		boolean output;
		int seq = 0;

		nums = new int[] { 4, 3, 2, 3, 5, 2, 1 };
		k = 4;
		expect = true;
		output = s.canPartitionKSubsets(nums, k);
		Util.verify(expect, output, ++seq);

	}

}
