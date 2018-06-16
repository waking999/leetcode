package lintcode.google.level1;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class AddStringsTest {
    @Test
    public void test1() {
        AddStrings s = new AddStrings();

        String num1;
        String num2;
        String expect;
        String output;
        int seq = 1;

        num1 = "19";
        num2 = "292";
        expect = "311";
        output = s.addStrings(num1, num2);
        verify(expect, output, seq++);

        num1 = "6";
        num2 = "501";
        expect = "507";
        output = s.addStrings(num1, num2);
        verify(expect, output, seq++);

        num1 = "501";
        num2 = "6";
        expect = "507";
        output = s.addStrings(num1, num2);
        verify(expect, output, seq++);

        num1 = "999";
        num2 = "1";
        expect = "1000";
        output = s.addStrings(num1, num2);
        verify(expect, output, seq++);

        num1 = null;
        num2 = "1";
        expect = "1";
        output = s.addStrings(num1, num2);
        verify(expect, output, seq++);


        num1 = "1";
        num2 = null;
        expect = "1";
        output = s.addStrings(num1, num2);
        verify(expect, output, seq++);

        num1 = "1";
        num2 = "999";
        expect = "1000";
        output = s.addStrings(num1, num2);
        verify(expect, output, seq++);


    }
}
