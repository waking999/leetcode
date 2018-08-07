package leetcode.attempt;

import common.Util;
import org.junit.jupiter.api.Test;

public class RemoveKDigitsTest {
    @Test
    public void test1() {
        RemoveKDigits s = new RemoveKDigits();
        /*
         * Input: num = "1432219", k = 3
         * Output: "1219"
         * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
         * Example 2:
         *
         * Input: num = "10200", k = 1
         * Output: "200"
         * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
         * Example 3:
         *
         * Input: num = "10", k = 2
         * Output: "0"
         * Explanation: Remove all the di
         */

        String num;
        int k;
        String expect;
        String output;
        int seq = 1;


        num = "1432219";
        k = 3;
        expect = "1219";
        output = s.removeKdigits(num, k);
        Util.verify(expect, output, seq++);


        num = "10200";
        k = 1;
        expect = "200";
        output = s.removeKdigits(num, k);
        Util.verify(expect, output, seq++);


        num = "10";
        k = 2;
        expect = "0";
        output = s.removeKdigits(num, k);
        Util.verify(expect, output, seq++);

    }
}
