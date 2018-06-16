package leetcode.success.string;

import org.junit.Test;

import static common.Util.verify;

public class LongestCommonPrefixTest {
    @Test
    public void test1() {
        LongestCommonPrefix s = new LongestCommonPrefix();

        String[] input;
        String expect;
        String output;
        int seq = 0;

        input = new String[]{"geeksforgeeks", "geeks", "geezer"};
        expect = "gee";
        output = s.longestCommonPrefix(input);
        verify(expect, output, seq++);

        input = new String[]{"apple", "ape", "april"};
        expect = "ap";
        output = s.longestCommonPrefix(input);
        verify(expect, output, seq++);
    }
}
