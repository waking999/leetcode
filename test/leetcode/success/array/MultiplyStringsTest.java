package leetcode.success.array;


import org.junit.Test;

import static common.Util.verify;

public class MultiplyStringsTest {
    @Test
    void testmultiply() {
        MultiplyStrings s = new MultiplyStrings();
        String num1;
        String num2;
        String expect;
        String output;
        int seq = 0;


        num1 = "2";
        num2 = "3";
        expect = "6";
        output = s.multiply(num1, num2);
        verify(expect, output, seq++);

        num1 = "123";
        num2 = "456";
        expect = "56088";
        output = s.multiply(num1, num2);
        verify(expect, output, seq++);

        num1 = "9";
        num2 = "9";
        expect = "81";
        output = s.multiply(num1, num2);
        verify(expect, output, seq++);

        num1 = "999";
        num2 = "999";
        expect = "998001";
        output = s.multiply(num1, num2);
        verify(expect, output, seq++);

        num1 = "9133";
        num2 = "0";
        expect = "0";
        output = s.multiply(num1, num2);
        verify(expect, output, seq++);

    }
}
