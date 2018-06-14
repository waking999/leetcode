package leetcode.success.dp;

public class ClimbingStairs {
//	public int climbStairs(int n) {
//		if (n <= 2) {
//			return n;
//		}
//
//		int[] dp = new int[n + 1];
//
//		dp[1] = 1;
//		dp[2] = 2;
//
//		for (int i = 3; i <= n; i++) {
//			dp[i] = dp[i - 1] + dp[i - 2];
//		}
//		return dp[n];
//	}


    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        //int[] dp = new int[n + 1];

        int a = 1;
        int b = 2;
        int c = a + b;

        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }


}
