package leetcode.success.math;

public class MinimumMovesToEqualArrayElements {
	public int minMoves(int[] nums) {
		int numsLen=nums.length;
		int sum=0;
		int min=Integer.MAX_VALUE;
		for (int num : nums) {
			sum += num;
			if (num <= min) {
				min = num;
			}
		}
		
		return sum-min*numsLen;
	}
	



}
