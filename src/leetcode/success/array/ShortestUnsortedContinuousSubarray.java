package leetcode.success.array;

import java.util.Arrays;

import leetcode.success.comm.Util;
import org.junit.Test;

public class ShortestUnsortedContinuousSubarray {
	public int findUnsortedSubarray(int[] nums) {
		if (nums == null) {
			return 0;
		}
		int numsLen = nums.length;
		if (numsLen <= 1) {
			return 0;
		}

		int[] nums1=Arrays.copyOf(nums, numsLen);
		Arrays.sort(nums1);
		
		int start=numsLen-1;
		for(int i=0;i<numsLen;i++) {
			if(nums1[i]!=nums[i]) {
				start=i;
				break;
			}
		}
		int end=0;
		for(int i=numsLen-1;i>=0;i--) {
			if(nums1[i]!=nums[i]) {
				end=i;
				break;
			}
		}
		if(start>end) {
			return 0;
		}
		return end-start+1;
	}
    @Test
    public void test1() {
		ShortestUnsortedContinuousSubarray s=new ShortestUnsortedContinuousSubarray();
		
		int[] nums;
		int expect;
		int output;
		
		
		nums=new int[] {2, 6, 4, 8, 10, 9, 15};
		expect=5;
		output=s.findUnsortedSubarray(nums);
		Util.verify(expect, output, 1);
		
		
		nums=new int[] {1,2,3,4};
		expect=0;
		output=s.findUnsortedSubarray(nums);
		Util.verify(expect, output, 2);
		
		nums=new int[] {1,3,2,2,2};
		expect=4;
		output=s.findUnsortedSubarray(nums);
		Util.verify(expect, output, 3);
		
		nums=new int[] {1,2,3,3,3};
		expect=0;
		output=s.findUnsortedSubarray(nums);
		Util.verify(expect, output, 4);
	}

}
