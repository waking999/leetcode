package history;


import common.Util;
import org.junit.jupiter.api.Test;


public class NumberOfBitsTest {

    @Test
    public void test1() {
        NumberOfBits s = new NumberOfBits();

        int n;
        int expect;
        int output;
        int seq = 1;

        n = 11;
        expect = 3;
        output = s.hammingWeight(n);
        Util.verify(expect, output, seq++);

        n = 255;
        expect = 8;
        output = s.hammingWeight(n);
        Util.verify(expect, output, seq++);

        n = Integer.MIN_VALUE;
        expect = 1;
        output = s.hammingWeight(n);
        Util.verify(expect, output, seq++);
    }
}
