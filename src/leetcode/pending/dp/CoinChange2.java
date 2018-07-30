package leetcode.pending.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/coin-change-2/description/
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 * <p>
 * Note: You can assume that
 * <p>
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: amount = 10, coins = [10]
 * Output: 1
 */
public class CoinChange2 {

    public int change(int amount, int[] coins) {
        int coinsLen = coins.length;
        if (amount == 0) {
            return 1;
        }
        Arrays.sort(coins);
        int[] counts = new int[coinsLen];


        Set<String> combin = new HashSet<>();
        for (int from = coinsLen - 1; from >= 0; from--) {
            helper(amount, coins, counts, 0, from, combin);
        }

        return combin.size();
    }

    private void helper(int amount, int[] coins, int[] counts, int tmpAmount, int from, Set<String> combin) {
        if (tmpAmount == amount) {

            String s = arrayToStr(counts);
            combin.add(s);
            return;
        }
        if (tmpAmount > amount) {
            return;
        }

        int remaning = amount - tmpAmount;
        int pos = find1stSmallerCoinPosition(coins, remaning, from);
        if (pos == -1) {
            return;
        }
        int coinCount = remaning / coins[pos];
        for (int i = coinCount; i >= 0; i--) {
            counts[pos] += i;
            tmpAmount += i * coins[pos];
            helper(amount, coins, counts, tmpAmount, from - 1, combin);
            tmpAmount -= i * coins[pos];
            counts[pos] -= i;
        }


    }

    private String arrayToStr(int[] counts) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < counts.length; i++) {
            sb.append(counts[i]).append(",");
        }
        return sb.toString();
    }

    private int find1stSmallerCoinPosition(int[] coins, int target, int from) {
        int i = from;
        while (i >= 0) {
            if (coins[i] <= target) {
                return i;
            }
            i--;
        }
        return -1;
    }
}
