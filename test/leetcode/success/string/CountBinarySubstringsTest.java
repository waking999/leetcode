package leetcode.success.string;

import org.junit.Test;

import static common.Util.verify;

public class CountBinarySubstringsTest {
    @Test
    public void test1() {
        CountBinarySubstrings s = new CountBinarySubstrings();

        String str;
        int expect;
        int output;
        int seq = 0;


        str = "00110011";
        expect = 6;
        output = s.countBinarySubstrings(str);
        verify(expect, output, ++seq);

        str = "10101";
        expect = 4;
        output = s.countBinarySubstrings(str);
        verify(expect, output, ++seq);
    }
}
