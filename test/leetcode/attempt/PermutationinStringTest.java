package leetcode.attempt;

import common.Util;
import org.junit.jupiter.api.Test;

public class PermutationinStringTest {
    @Test
    public void test1() {
        PermutationinString s = new PermutationinString();

        String s1;
        String s2;
        boolean expect;
        boolean output;
        int seq = 1;


        s1 = "ab";
        s2 = "eidbaooo";
        expect = true;
        output = s.checkInclusion(s1, s2);
        Util.verify(expect, output, seq++);

        s1 = "ab";
        s2 = "eidboaoo";
        expect = false;
        output = s.checkInclusion(s1, s2);
        Util.verify(expect, output, seq++);


        s1 = "abc";
        s2 = "eidbacoo";
        expect = true;
        output = s.checkInclusion(s1, s2);
        Util.verify(expect, output, seq++);


        s1 = "abcdxabcde";
        s2 = "abcdeabcdx";
        expect = true;
        output = s.checkInclusion(s1, s2);
        Util.verify(expect, output, seq++);
    }
}
