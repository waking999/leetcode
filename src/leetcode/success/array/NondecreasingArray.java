package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

public class NondecreasingArray {
	public boolean checkPossibility(int[] nums) {
		if(nums==null) {
			return true;
		}
		int numsLen=nums.length;
		if(numsLen<=1) {
			return true;
		}
		
		int count=0;
		for(int i=1;i<numsLen;i++) {
			if(nums[i-1]>nums[i]) {
				count++;
				if(count>=2) {
					return false;
				}
			}
			if(i!=1 && i!=numsLen-1) {
				if(nums[i-2]>nums[i] && nums[i-1]>nums[i+1]) {
					return false;
				}
			}
		}
		return true;
	}

    @Test
    public void test1() {
		NondecreasingArray s = new NondecreasingArray();

		int[] nums;
		boolean expect;
		boolean output;

		nums = new int[] { 4, 2, 3 };
		expect = true;
		output = s.checkPossibility(nums);
		Util.verify(expect, output, 1);

		nums = new int[] { 4, 2, 1 };
		expect = false;
		output = s.checkPossibility(nums);
		Util.verify(expect, output, 2);

		nums = new int[] { 3, 4, 2, 3 };
		expect = false;
		output = s.checkPossibility(nums);
		Util.verify(expect, output, 3);
		
		System.out.println("Finish");
	}

}
