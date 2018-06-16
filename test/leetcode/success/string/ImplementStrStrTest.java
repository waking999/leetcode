package leetcode.success.string;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class ImplementStrStrTest {
    @Test
    public void test1() {
        ImplementStrStr s = new ImplementStrStr();

        String s1;
        String s2;
        int expect;
        int output;
        int seq = 0;

        s1 = "abcdef";
        s2 = "cde";
        expect = 2;
        output = s.strStr(s1, s2);
        verify(expect, output, seq++);

        s1 = "abcedef";
        s2 = "cde";
        expect = -1;
        output = s.strStr(s1, s2);
        verify(expect, output, seq++);

        s1 = "";
        s2 = "";
        expect = 0;
        output = s.strStr(s1, s2);
        verify(expect, output, seq++);

        s1 = "";
        s2 = "a";
        expect = -1;
        output = s.strStr(s1, s2);
        verify(expect, output, seq++);

        s1 = "a";
        s2 = "";
        expect = 0;
        output = s.strStr(s1, s2);
        verify(expect, output, seq++);

        s1 = "aaa";
        s2 = "a";
        expect = 0;
        output = s.strStr(s1, s2);
        verify(expect, output, seq++);

        s1 = "aaa";
        s2 = "aaaa";
        expect = -1;
        output = s.strStr(s1, s2);
        verify(expect, output, seq++);

        s1 = "aabaaaababaababaa";
        s2 = "bbbb";
        expect = -1;
        output = s.strStr(s1, s2);
        verify(expect, output, seq++);

        s1 = "a";
        s2 = "a";
        expect = 0;
        output = s.strStr(s1, s2);
        verify(expect, output, seq++);

        s1 = "mississippi";
        s2 = "issip";
        expect = 4;
        output = s.strStr(s1, s2);
        verify(expect, output, seq++);

        s1 = "mississippi";
        s2 = "pi";
        expect = 9;
        output = s.strStr(s1, s2);
        verify(expect, output, seq++);
    }
}
