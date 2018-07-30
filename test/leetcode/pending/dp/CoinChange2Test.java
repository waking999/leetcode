package leetcode.pending.dp;

import common.Util;
import org.junit.jupiter.api.Test;

public class CoinChange2Test {
    @Test
    public void test1() {
        CoinChange2 s = new CoinChange2();
/*
Example 1:
 *
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 *
 * Example 2:
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 *
 *
 * Example 3:
 *
 * Input: amount = 10, coins = [10]
 * Output: 1
 */

        int amount;
        int[] coins;
        int expect;
        int output;
        int seq = 1;

        amount = 5;
        coins = new int[]{1, 2, 5};
        expect = 4;
        output = s.change(amount, coins);
        Util.verify(expect, output, seq++);


        amount = 3;
        coins = new int[]{2};
        expect = 0;
        output = s.change(amount, coins);
        Util.verify(expect, output, seq++);

        amount = 10;
        coins = new int[]{10};
        expect = 1;
        output = s.change(amount, coins);
        Util.verify(expect, output, seq++);

        amount = 0;
        coins = new int[]{};
        expect = 1;
        output = s.change(amount, coins);
        Util.verify(expect, output, seq++);

//        amount = 500;
//        coins = new int[]{1,2,5};
//        expect = 12701;
//        output = s.change(amount, coins);
//        Util.verify(expect, output, seq++);

        amount = 500;
        coins = new int[]{2,7,13};
        expect = 717;
        output = s.change(amount, coins);
        Util.verify(expect, output, seq++);
    }
}
