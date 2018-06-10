package leetcode.success.array;

public class PluseOne {
	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i] = digits[i] + 1;
				return digits;
			} else {
				digits[i] = 0;
			}
		}
		int[] res = new int[digits.length + 1];
		res[0] = 1;
		return res;
	}

	public static void main(String[] args) {
		PluseOne s = new PluseOne();

		int[] nums = { 1, 9, 9 };
		int[] expect = { 2, 0, 0 };
		int[] output = s.plusOne(nums);
		for (int i = 0; i < output.length; i++) {
			assert (nums[i] == expect[i]) : "1.wrong";
		}

		nums = new int[] { 1, 9, 8 };
		expect = new int[] { 2, 0, 0 };
		output = s.plusOne(nums);
		for (int i = 0; i < output.length; i++) {
			assert (nums[i] == expect[i]) : "2.wrong";
		}

		nums = new int[] { 1, 9 };
		expect = new int[] { 2, 0 };
		output = s.plusOne(nums);
		for (int i = 0; i < output.length; i++) {
			assert (nums[i] == expect[i]) : "3.wrong";
		}

		nums = new int[] { 9, 9, 9 };
		expect = new int[] { 1, 0, 0, 0 };
		output = s.plusOne(nums);
		for (int i = 0; i < output.length; i++) {
			assert (nums[i] == expect[i]) : "4.wrong";
		}
		
		nums = new int[] { 1, 8, 9 };
		expect = new int[] { 1, 9, 0 };
		output = s.plusOne(nums);
		for (int i = 0; i < output.length; i++) {
			assert (nums[i] == expect[i]) : "5.wrong";
		}


		System.out.println("Finish");
	}

}
