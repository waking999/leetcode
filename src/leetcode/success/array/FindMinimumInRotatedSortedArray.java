package leetcode.success.array;

import org.junit.Test;

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {

		int n = nums.length;
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return nums[0];
		} else if (n == 2) {
			return Math.min(nums[0], nums[1]);
		}

		int low = 0;
		int high = n - 1;
		while (low < high - 1) {
			if (nums[low] < nums[high]) {
				return nums[low];
			}
			int mid = (low + high) / 2;
			if (nums[mid] > nums[low]) {
				// must be in right half
				low = mid ;
			} else if (nums[mid] < nums[low]) {
				// must be in left half
				high = mid ;
			}
		}

		return Math.min(nums[low], nums[high]);
	}

	@Test
	public void test1() {

		FindMinimumInRotatedSortedArray s = new FindMinimumInRotatedSortedArray();

		int[] nums;
		int expect;
		int output;

		nums = new int[] { 0, 1, 2, 4, 5, 6, 7 };
		expect = 0;
		output = s.findMin(nums);
		assert (output == expect) : "1.wrong";

		nums = new int[] { 4, 5, 6, 7, 0, 1, 2};
		expect = 0;
		output = s.findMin(nums);
		assert (output == expect) : "2.wrong";
		
		nums = new int[] { 3,1,2 };
		expect = 1;
		output = s.findMin(nums);
		assert (output == expect) : "3.wrong";

		System.out.println("Finish");
	}

}
