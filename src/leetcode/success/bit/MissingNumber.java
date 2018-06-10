package leetcode.success.bit;

public class MissingNumber {
	public int missingNumber(int[] nums) {
		int numsLen=nums.length;
		 
		int sumn=numsLen*(numsLen+1)/2;
		int sumnums=0;
		for(int num:nums){
			sumnums+=num;
		}
		
		
		return sumn-sumnums;
	}

	public static void main(String[] args) {
		MissingNumber s = new MissingNumber();

		int[] nums;
		int expect;
		int output;

		nums = new int[] { 0, 1, 3 };
		expect = 2;
		output = s.missingNumber(nums);
		assert (output == expect) : "1.wrong";
		
		
		System.out.println("Finish");
	}

}
