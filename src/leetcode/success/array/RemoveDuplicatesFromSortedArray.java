package leetcode.success.array;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int numsLen=nums.length;
		if(numsLen==0){
			return 0;
		}
		
		int j=0;
		for(int i=1;i<numsLen;i++){
			if(nums[j]!=nums[i]){
				j++;
				nums[j]=nums[i];
			}
		}
		return j+1;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray s = new RemoveDuplicatesFromSortedArray();

		int[] nums = { 2, 2, 3, 3 };
		int[] expectNums = { 2, 3 };
		int expect = 2;

		int output = s.removeDuplicates(nums);
		assert (output == expect) : "1.wrong";
		for (int i = 0; i < output; i++) {
			assert (nums[i] == expectNums[i]) : "1.wrong";
		}

		nums = new int[] { 1, 2, 2, 2, 3, 4 };

		expectNums = new int[] { 1, 2, 3, 4 };
		expect = 4;

		output = s.removeDuplicates(nums);
		assert (output == expect) : "2.wrong";
		for (int i = 0; i < output; i++) {
			assert (nums[i] == expectNums[i]) : "2.wrong";
		}

		System.out.println("Finish");

	}

}
