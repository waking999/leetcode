package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

public class BuddyStringsTest {
    @Test
    public void test1() {
        BuddyStrings s = new BuddyStrings();
        String A;
        String B;
        boolean expect;
        boolean output;
        int seq = 1;


        A = "ab";
        B = "ba";
        expect = true;
        output = s.buddyStrings(A, B);
        Util.verify(expect, output, seq++);

        A = "ab";
        B = "ab";
        expect = false;
        output = s.buddyStrings(A, B);
        Util.verify(expect, output, seq++);

        A = "aa";
        B = "aa";
        expect = true;
        output = s.buddyStrings(A, B);
        Util.verify(expect, output, seq++);

        A = "aaaaaaabc";
        B = "aaaaaaacb";
        expect = true;
        output = s.buddyStrings(A, B);
        Util.verify(expect, output, seq++);

        A = "";
        B = "aa";
        expect = false;
        output = s.buddyStrings(A, B);
        Util.verify(expect, output, seq++);


        A = "abc";
        B = "adc";
        expect = false;
        output = s.buddyStrings(A, B);
        Util.verify(expect, output, seq++);


        A = "abc";
        B = "bdc";
        expect = false;
        output = s.buddyStrings(A, B);
        Util.verify(expect, output, seq++);


        A = "abab";
        B = "abab";
        expect = true;
        output = s.buddyStrings(A, B);
        Util.verify(expect, output, seq++);

    }
}
