package lintcode.google.level1;

/**
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 * Return the total number of ways you can paint the fence.
 * <p>
 * n and k are non-negative integers.
 * <p>
 * https://www.jianshu.com/p/6ea952b9be9e
 * Example
 * Given n=3, k=2 return 6
 * <p>
 * post 1,   post 2, post 3
 * way1    0         0       1
 * way2    0         1       0
 * way3    0         1       1
 * way4    1         0       0
 * way5    1         0       1
 * way6    1         1       0
 */
public class PaintFence {

    /*
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) {
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


}
