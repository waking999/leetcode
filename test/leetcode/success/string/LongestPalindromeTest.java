package leetcode.success.string;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class LongestPalindromeTest {
    @Test
    public void test1() {
        LongestPalindrome s = new LongestPalindrome();

        String str;
        int expect;
        int output;

        str = "abccccdd";
        expect = 7;
        output = s.longestPalindrome(str);
        verify(expect, output, 1);

        str = "ccc";
        expect = 3;
        output = s.longestPalindrome(str);
        verify(expect, output, 2);

        System.out.println("Finish");
    }
}
