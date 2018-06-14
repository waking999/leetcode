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



}
