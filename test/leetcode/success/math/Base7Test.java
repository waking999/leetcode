package leetcode.success.math;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class Base7Test {
    @Test
    public void test1() {
        Base7 s = new Base7();

        int num;
        String expect;
        String output;

        num = 100;
        expect = "202";
        output = s.convertToBase7(num);
        verify(expect, output, 1);

        num = -7;
        expect = "-10";
        output = s.convertToBase7(num);
        verify(expect, output, 2);

        num = -8;
        expect = "-11";
        output = s.convertToBase7(num);
        verify(expect, output, 2);


    }
}
