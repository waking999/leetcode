package leetcode.success.string;

import org.junit.Test;

import static common.Util.verify;

public class RepeatedSubstringPatternTest {
    @Test
    public void test1() {
        RepeatedSubstringPattern s = new RepeatedSubstringPattern();

        String str;
        boolean expect;
        boolean output;

        str = "abab";
        expect = true;
        output = s.repeatedSubstringPattern(str);
        verify(expect, output, 1);

        str = "aba";
        expect = false;
        output = s.repeatedSubstringPattern(str);
        verify(expect, output, 2);

        str = "abcabcabcabc";
        expect = true;
        output = s.repeatedSubstringPattern(str);
        verify(expect, output, 3);

    }
}
