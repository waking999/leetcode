package leetcode.success.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/description/
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null) {
            return -1;
        }
        int coinsLen = coins.length;
        if (coinsLen == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (amount < coins[0]) {
            return -1;
        }

        found = false;
        totalCount = 0;
          minTotal = Integer.MAX_VALUE;

        Arrays.sort(coins);

        for (int i = coinsLen - 1; i >= 0; i--) {
            coinCount = new int[coinsLen];
            helper(coins, i, amount);
            if (found) {
                for (int j = 0; j < coinsLen; j++) {
                    System.out.print(coins[j] + ":" + coinCount[j]+";");
                }
                minTotal = Math.min(minTotal, totalCount);

            }

            System.out.println();
        }
        if (found) {
            System.out.println(minTotal);
            return minTotal;
        }
        return -1;
    }

    private int totalCount;
    private boolean found;
    private int[] coinCount;
private int minTotal;

    private void helper(int[] coins, int coinsPos, int amount) {
        if (coinsPos < 0) {
            return;
        }
        while (coinsPos >= 0 && amount < coins[coinsPos]) {
            coinsPos--;
        }
        if (coinsPos < 0) {
            return;
        }
        int count = amount / coins[coinsPos];
        totalCount += count;
        amount -= count * coins[coinsPos];
        coinCount[coinsPos] = count;
        if (amount == 0) {
            found = true;
            return;
        }

        helper(coins, coinsPos - 1, amount);
        if (!found) {
            for (int i = count - 1; i >= 1; i--) {
                totalCount--;
                amount += coins[coinsPos];
                coinCount[coinsPos]--;
                helper(coins, coinsPos - 1, amount);
                if (found) {
                    return;
                }
            }
            if (!found) {

                totalCount--;
                amount += coins[coinsPos];
                coinCount[coinsPos]--;
                helper(coins, coinsPos - 1, amount);
            }
        }
    }
}
