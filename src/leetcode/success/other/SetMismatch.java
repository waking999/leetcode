package leetcode.success.other;

public class SetMismatch {
	public int[] findErrorNums(int[] nums) {
		int[] res = new int[2];
		int numsLen = nums.length;
		int[] cnt = new int[numsLen];
		for (int num : nums) {
			cnt[num - 1]++;
		}
		for (int i = 0; i < numsLen; i++) {

			if (res[0] != 0 && res[1] != 0)
				return res;
			if (cnt[i] == 2)
				res[0] = i + 1;
			else if (cnt[i] == 0)
				res[1] = i + 1;
		}
		return res;
	}

	public static void main(String[] args) {
		SetMismatch s = new SetMismatch();

		int[] input = { 1, 2, 2, 4 };
		int[] expect = { 2, 3 };
		int[] output = s.findErrorNums(input);
		assert (expect[0] == output[0]) : "1.wrong";
		assert (expect[1] == output[1]) : "1.wrong";

		input = new int[] { 1, 1 };
		expect = new int[] { 1, 2 };
		output = s.findErrorNums(input);
		assert (expect[0] == output[0]) : "2.wrong";
		assert (expect[1] == output[1]) : "2.wrong";

		System.out.println("Finish");

	}

}
