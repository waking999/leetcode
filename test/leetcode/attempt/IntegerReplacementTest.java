package leetcode.attempt;

import common.Util;
import org.junit.Test;

public class IntegerReplacementTest {
    @Test
    public void test1() {
        IntegerReplacement x = new IntegerReplacement();

        int n;
        int expect;
        int output;
        int seq = 1;

        n = 8;
        expect = 3;
        output = x.integerReplacement(n);
        Util.verify(expect, output, seq++);

        n = 7;
        expect = 4;
        output = x.integerReplacement(n);
        Util.verify(expect, output, seq++);

        n = 1;
        expect = 0;
        output = x.integerReplacement(n);
        Util.verify(expect, output, seq++);

        n = 0;
        expect = 0;
        output = x.integerReplacement(n);
        Util.verify(expect, output, seq++);

        n = 2;
        expect = 1;
        output = x.integerReplacement(n);
        Util.verify(expect, output, seq++);

        n = 2147483647;
        expect = 32;
        output = x.integerReplacement(n);
        Util.verify(expect, output, seq++);
    }
}
