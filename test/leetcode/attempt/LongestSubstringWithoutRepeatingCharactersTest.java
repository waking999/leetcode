package leetcode.attempt;

import leetcode.success.comm.Util;
import org.junit.Test;

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
        Util.verify(expect, output, seq++);


        str = "bbbbb";
        expect = 1;
        output = s.lengthOfLongestSubstring(str);
        Util.verify(expect, output, seq++);


        str = "pwwkew";
        expect = 3;
        output = s.lengthOfLongestSubstring(str);
        Util.verify(expect, output, seq++);

        str = "cdd";
        expect = 2;
        output = s.lengthOfLongestSubstring(str);
        Util.verify(expect, output, seq++);

    }

}
