package leetcode.success.array;

import java.util.Arrays;

import leetcode.success.comm.Util;
import org.junit.Test;

public class ArrayPartitionI {
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum=0;
		for(int i=0;i<nums.length-1;i+=2) {
			sum+=nums[i];
		}
		
		
		return sum;
	}

	@Test
	public void test1() {
		ArrayPartitionI s=new ArrayPartitionI();
		
		int[] nums;
		int expect;
		int output;
		
		nums=new int[] {1,4,3,2};
		expect=4;
		output=s.arrayPairSum(nums);
		Util.verify(expect, output, 1);

	}

}
