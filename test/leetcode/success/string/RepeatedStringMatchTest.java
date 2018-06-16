package leetcode.success.string;

import org.junit.Test;

import static common.Util.verify;

public class RepeatedStringMatchTest {


    @Test
    public void test1() {
        RepeatedStringMatch s = new RepeatedStringMatch();

        String A;
        String B;
        int expect;
        int output;
        int seq = 0;

        A = "abcd";
        B = "cdabcdab";
        expect = 3;
        output = s.repeatedStringMatch(A, B);
        verify(expect, output, ++seq);


        A = "aaaa";
        B = "a";
        expect = 1;
        output = s.repeatedStringMatch(A, B);
        verify(expect, output, ++seq);


        A = "abaabaa";
        B = "abaababaab";
        expect = -1;
        output = s.repeatedStringMatch(A, B);
        verify(expect, output, ++seq);
    }
}
