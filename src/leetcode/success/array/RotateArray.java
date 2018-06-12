package leetcode.success.array;

import org.junit.Test;

public class RotateArray {


	public void rotate(int[] nums, int k) {
		int numsLen = nums.length;
		if (numsLen <= 1) {
			return;
		}
		if (k <= 0) {
			return;
		}
		k=k%numsLen;
		for(int i=1;i<=k;i++){
			int t=nums[numsLen-1];

			System.arraycopy(nums, 0, nums, 1, numsLen - 2 + 1);
			nums[0]=t;
		}

	}
	@Test
	public void test1() {
		RotateArray s = new RotateArray();

		int[] nums;
		int k;
		int[] expect;

		nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		k = 3;
		expect = new int[] { 5, 6, 7, 1, 2, 3, 4 };
		s.rotate(nums, k);
		for (int i = 0; i < nums.length; i++) {
			assert (expect[i] == nums[i]) : "1:wrong";
		}
		
		nums = new int[] { 1, 2};
		k = 1;
		expect = new int[] {2,1 };
		s.rotate(nums, k);
		for (int i = 0; i < nums.length; i++) {
			assert (expect[i] == nums[i]) : "2:wrong";
		}
		
		nums = new int[] { 1, 2};
		k = 3;
		expect = new int[] {2,1 };
		s.rotate(nums, k);
		for (int i = 0; i < nums.length; i++) {
			assert (expect[i] == nums[i]) : "2:wrong";
		}

		System.out.println("Finish");
	}

}
