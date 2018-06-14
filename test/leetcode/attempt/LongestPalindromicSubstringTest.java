package leetcode.attempt;

import common.Util;
import org.junit.Test;

public class LongestPalindromicSubstringTest {
    @Test
    public void testlongestPalindrome() {
        LongestPalindromicSubstring s = new LongestPalindromicSubstring();

        String str;
        String expect;
        String output;
        int seq = 0;

        str = "babad";
        expect = "bab";
        output = s.longestPalindrome(str);
        Util.verify(expect, output, seq++);

        str = "cbbd";
        expect = "bb";
        output = s.longestPalindrome(str);
        Util.verify(expect, output, seq++);


    }
}
