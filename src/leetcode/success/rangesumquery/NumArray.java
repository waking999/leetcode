package leetcode.success.rangesumquery;

public class NumArray {
	int[] dp;

	public NumArray(int[] nums) {
		dp = nums;
		for (int i = 1; i < nums.length; ++i) {
			dp[i] += dp[i - 1];
		}
	}

	public int sumRange(int i, int j) {
		return i == 0 ? dp[j] : dp[j] - dp[i - 1];
	}

	public static void main(String[] args) {
		int[] nums = { -2, 0, 3, -5, 2, -1 };
		NumArray na = new NumArray(nums);

		int i = 0;
		int j = 2;
		int expect = 1;
		int s = na.sumRange(i, j);
		assert (s == expect) : "1. not right";

		i = 2;
		j = 5;
		expect = -1;
		s = na.sumRange(i, j);
		assert (s == expect) : "2. not right";

		i = 0;
		j = 5;
		expect = -3;
		s = na.sumRange(i, j);
		assert (s == expect) : "3. not right";

		System.out.println("Finish");

	}

}
