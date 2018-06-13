package lintcode.google;

import leetcode.success.comm.Util;
import org.junit.Test;

public class PaintFence {
    /**
     * There is a fence with n posts, each post can be painted with one of the k colors.
     * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
     * Return the total number of ways you can paint the fence.
     *
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    /**
     * https://www.jianshu.com/p/6ea952b9be9e
     *
     */
    public int numWays(int n, int k) {
        // write your code here
        if (n <= 1 || k <= 0) {
            return n * k;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k + k * (k - 1);
        for (int i = 3; i < n + 1; i++) {
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n];

    }


    @Test
    public void testnumWays() {
        PaintFence s = new PaintFence();

        int n;
        int k;
        int expect;
        int output;
        int seq = 1;

        n = 3;
        k = 2;
        expect = 6;
        output = s.numWays(n, k);
        Util.verify(expect, output, seq++);

    }


}
