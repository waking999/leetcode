package leetcode.attempt;

import leetcode.success.comm.Util;
import org.junit.Test;

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

	@Test
	public void testclimbStairs() {
		ClimbingStairs s=new ClimbingStairs();
		
		int n;
		int expect;
		int output;
		int seq=0;
		
		n=3;
		expect=3;
		output=s.climbStairs(n);
		Util.verifyUnsort(expect, output, seq++);

	}

}
