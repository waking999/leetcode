package leetcode.success.array;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int j=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=val){
				nums[j]=nums[i];
				j++;
			}
		}
		
		return j;
	}

	public static void main(String[] args) {
		RemoveElement s = new RemoveElement();

		int[] nums = { 3, 2, 2, 3 };
		int value = 3;
		int[] expectNums = { 2, 2 };
		int expect = 2;

		int output = s.removeElement(nums, value);
		assert (output == expect) : "1.wrong";
		for (int i = 0; i < output; i++) {
			assert (nums[i] == expectNums[i]) : "1.wrong";
		}

		nums = new int[] { 1, 2, 2, 3, 2, 4 };
		value = 2;
		expectNums = new int[] { 1, 3, 4 };
		expect = 3;

		output = s.removeElement(nums, value);
		assert (output == expect) : "2.wrong";
		for (int i = 0; i < output; i++) {
			assert (nums[i] == expectNums[i]) : "2.wrong";
		}

		System.out.println("Finish");
	}

}
