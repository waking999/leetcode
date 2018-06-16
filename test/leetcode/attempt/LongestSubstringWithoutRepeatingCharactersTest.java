package leetcode.attempt;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class LongestSubstringWithoutRepeatingCharactersTest {
    @Test
    public void testlengthOfLongestSubstring() {
        LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
        String str;
        int expect;
        int output;
        int seq = 0;

        str = "abcabcbb";
        expect = 3;
        output = s.lengthOfLongestSubstring(str);
        verify(expect, output, seq++);


        str = "bbbbb";
        expect = 1;
        output = s.lengthOfLongestSubstring(str);
        verify(expect, output, seq++);


        str = "pwwkew";
        expect = 3;
        output = s.lengthOfLongestSubstring(str);
        verify(expect, output, seq++);

        str = "cdd";
        expect = 2;
        output = s.lengthOfLongestSubstring(str);
        verify(expect, output, seq++);

    }

}
