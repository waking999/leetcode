package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

public class LongestContinuousIncreasingSubsequence {
	public int findLengthOfLCIS(int[] nums) {
		if(nums==null) {
			return 0;
		}
		int numsLen=nums.length;
		if(numsLen<=1) {
			return numsLen;
		}
		int answer=0;
		int length = 1; // just A[0] itself
        for (int i = 1; i < numsLen; i++) {
            if (nums[i] > nums[i - 1]) {
                length++;
            } else {
                length = 1;
            }
            answer = Math.max(answer, length);
        }
		
		
		return answer;
	}



    @Test
    public void test1() {
		LongestContinuousIncreasingSubsequence s=new LongestContinuousIncreasingSubsequence();

		int[] nums;
		int expect;
		int output;
		
		nums=new int[] {1,3,5,4,7};
		expect=3;
		output=s.findLengthOfLCIS(nums);
		Util.verifyUnsort(expect, output, 1);
		
		nums=new int[] {2,2,2,2};
		expect=1;
		output=s.findLengthOfLCIS(nums);
		Util.verifyUnsort(expect, output, 2);
		
		System.out.println("Finish");
	}

}
