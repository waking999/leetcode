package leetcode.attempt;

import common.Util;
import org.junit.Test;

public class DivideTwoIntegersTest {
    @Test
    public void test1() {
        DivideTwoIntegers s=new DivideTwoIntegers();

        int dividend;
        int divisor;
        int expect;
        int output;

        dividend=1;
        divisor=2;
        expect=0;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 5);

        dividend=2;
        divisor=3;
        expect=0;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 10);


        dividend=2;
        divisor=1;
        expect=2;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 15);

        dividend=3;
        divisor=2;
        expect=1;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 20);

        dividend=2;
        divisor=2;
        expect=1;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 25);


        dividend=1;
        divisor=0;
        expect=Integer.MAX_VALUE;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output,30);


        dividend=1;
        divisor=-2;
        expect=0;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 35);

        dividend=2;
        divisor=-3;
        expect=0;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 40);


        dividend=-1;
        divisor=2;
        expect=0;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 45);

        dividend=-2;
        divisor=3;
        expect=0;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 50);

        dividend=2;
        divisor=-1;
        expect=-2;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 55);

        dividend=3;
        divisor=-2;
        expect=-1;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 60);

        dividend=-2;
        divisor=1;
        expect=-2;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 65);


        dividend=-3;
        divisor=2;
        expect=-1;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 70);

        dividend=-1;
        divisor=-2;
        expect=0;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 75);

        dividend=-2;
        divisor=-3;
        expect=0;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 80);

        dividend=-2;
        divisor=-1;
        expect=2;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 85);

        dividend=-3;
        divisor=-2;
        expect=1;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 90);


        dividend=-1;
        divisor=0;
        expect=Integer.MAX_VALUE;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 95);

        dividend=-3;
        divisor=-3;
        expect=1;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 100);

        dividend=3;
        divisor=3;
        expect=1;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 105);

        dividend=-3;
        divisor=3;
        expect=-1;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 110);

        dividend=3;
        divisor=-3;
        expect=-1;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 115);

        dividend=-2147483648;
        divisor=-1;
        expect=2147483647;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 120);

        dividend=-2147483648;
        divisor=2;
        expect=-1073741824;
        output=s.divide(dividend, divisor);
        Util.verify(expect, output, 125);

    }
}
