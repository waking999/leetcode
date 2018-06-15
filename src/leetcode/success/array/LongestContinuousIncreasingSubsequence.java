package leetcode.success.array;

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




}
