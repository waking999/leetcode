package leetcode.success.string;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class RomanToIntegerTest {
    @Test
    public void test1() {
        RomanToInteger s = new RomanToInteger();

        String str;
        int expect;
        int output;
        int seq = 0;

        str = "I";
        expect = 1;
        output = s.romanToInt(str);
        verify(expect, output, seq++);

        str = "IX";
        expect = 9;
        output = s.romanToInt(str);
        verify(expect, output, seq++);

        str = "XII";
        expect = 12;
        output = s.romanToInt(str);
        verify(expect, output, seq++);

    }
}
