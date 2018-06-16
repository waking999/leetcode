package leetcode.success.other;

import static common.Util.verify;

public class BinaryNumberwithAlternatingBitsTest {
    public static void main(String[] args) {
        BinaryNumberwithAlternatingBits s = new BinaryNumberwithAlternatingBits();

        int n;
        boolean expect;
        boolean output;
        int seq = 0;

        n = 5;
        expect = true;
        output = s.hasAlternatingBits(n);
        verify(expect, output, ++seq);

        n = 7;
        expect = false;
        output = s.hasAlternatingBits(n);
        verify(expect, output, ++seq);

        n = 11;
        expect = false;
        output = s.hasAlternatingBits(n);
        verify(expect, output, ++seq);

        n = 10;
        expect = true;
        output = s.hasAlternatingBits(n);
        verify(expect, output, ++seq);
    }
}
