package leetcode.success.array;

public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}

		int num = 0;
		int j = 0;
		for (int i = 1; i < n; i++) {
			if (nums[i] == nums[j]) {
				num++;
				if(num<2){					
					nums[++j]=nums[i];
				}
			} else {
				nums[++j] = nums[i];
				num = 0;
			}
		}

		return j + 1;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArrayII s = new RemoveDuplicatesFromSortedArrayII();

		int[] nums;
		int[] expectNums;
		int expect;
		int output;

		nums = new int[] { 1, 1, 1, 2, 2, 3 };
		expectNums = new int[] { 1, 1, 2, 2, 3 };
		expect = 5;

		output = s.removeDuplicates(nums);
		assert (output == expect) : "1.wrong";
		for (int i = 0; i < output; i++) {
			assert (nums[i] == expectNums[i]) : "1.wrong";
		}

		System.out.println("Finish");
	}

}
