package leetcode.attempt;

import leetcode.success.comm.Util;

public class ClimbingStairs {
	public int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}

		int[] dp = new int[n + 1];

		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public static void main(String[] args) {
		ClimbingStairs s=new ClimbingStairs();
		
		int n;
		int expect;
		int output;
		int seq=0;
		
		n=3;
		expect=3;
		output=s.climbStairs(n);
		Util.verify(expect, output, seq++);

	}

}
