package leetcode.success.array;

public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return  nums[0]>nums[1]?0:1;
		}

		int low = 0;
		int high = n - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1])) {
				return mid;
			} else if (mid>0&&nums[mid - 1] > nums[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return mid;
	}

	public static void main(String[] args) {
		FindPeakElement s = new FindPeakElement();

		int[] nums;
		int expect;
		int output;

		nums = new int[] { 4, 1, 5, 6, 2, 3 };
		expect = 3;
		output = s.findPeakElement(nums);
		assert (expect == output) : "1:wrong";

		nums = new int[] { 3, 4, 3, 2, 1 };
		expect = 1;
		output = s.findPeakElement(nums);
		assert (expect == output) : "2:wrong";

		nums = new int[] {1 };
		expect = 0;
		output = s.findPeakElement(nums);
		assert (expect == output) : "3:wrong";
		
		System.out.println("Finish");
	}

}
