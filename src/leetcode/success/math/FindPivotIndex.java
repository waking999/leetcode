package leetcode.success.math;

import leetcode.success.comm.Util;

public class FindPivotIndex {
	public int pivotIndex(int[] nums) {
		if(nums==null) {
			return -1;
		}
		int numsLen=nums.length;
		if(numsLen==0) {
			return -1;
		}
		if(numsLen==1) {
			return 0;
		}
		
		int[] sumNums=new int[numsLen+2];
		sumNums[0]=0;
		sumNums[1]=nums[0];
		sumNums[numsLen+1]=0;
		for(int i=2;i<numsLen+1;i++) {
			sumNums[i]=sumNums[i-1]+nums[i-1];
		}
		
		for(int i=1;i<numsLen+1;i++) {
			int left=sumNums[i-1];
			int right=sumNums[numsLen]-sumNums[i];
			if(left==right) {
				return i-1;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		FindPivotIndex s = new FindPivotIndex();

		int[] nums;
		int expect;
		int output;
		int seq=0;
		
		nums=new int[] {1, 7, 3, 6, 5, 6};
		expect=3;
		output=s.pivotIndex(nums);
		Util.verify(expect, output, seq++);
		
		nums=new int[] {1, 2, 3};
		expect=-1;
		output=s.pivotIndex(nums);
		Util.verify(expect, output, seq++);
		
		nums=new int[] {-1,-1,0,1,1,0};
		expect=5;
		output=s.pivotIndex(nums);
		Util.verify(expect, output, seq++);
		
	}

}
