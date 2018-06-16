package lintcode.google.level2.required;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class PowTest {
    @Test
    public void test1() {
        Pow s = new Pow();

        double x;
        int n;
        double expect;
        double output;
        int seq = 1;

        x = 2.1;
        n = 3;
        expect = 9.261;
        output = s.myPow(x, n);
        verify(expect, output, seq++);

        x = 0;
        n = 1;
        expect = 0;
        output = s.myPow(x, n);
        verify(expect, output, seq++);

        x = 1;
        n = 0;
        expect = 1;
        output = s.myPow(x, n);
        verify(expect, output, seq++);

        x = 8.88023;
        n = 3;
        expect = 700.28148;
        output = s.myPow(x, n);
        verify(expect, output, seq++);

        x = 2;
        n = -2147483648;
        expect = 0.00000;
        output = s.myPow(x, n);
        verify(expect, output, seq++);

        x = 11;
        n = 0;
        expect = 1;
        output = s.myPow(x, n);
        verify(expect, output, seq++);


        x = -1;
        n = 32;
        expect = 1;
        output = s.myPow(x, n);
        verify(expect, output, seq++);


        x = -1;
        n = 33;
        expect = -1;
        output = s.myPow(x, n);
        verify(expect, output, seq++);


        x = 0.00001;
        n = 33;
        expect = 0;
        output = s.myPow(x, n);
        verify(expect, output, seq++);


    }
}
