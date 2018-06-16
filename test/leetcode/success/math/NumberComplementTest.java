package leetcode.success.math;

import common.Util;
import org.junit.jupiter.api.Test;

import static common.Util.*;

public class NumberComplementTest {
    @Test
    public void test1() {
        NumberComplement s = new NumberComplement();

        int num;
        int expect;
        int output;

        num = 5;
        expect = 2;
        output = s.findComplement(num);
        verify(expect, output, 1);

        num = 1;
        expect = 0;
        output = s.findComplement(num);
        verify(expect, output, 2);

        num =2;
        expect = 1;
        output = s.findComplement(num);
        verify(expect, output, 2);

    }

}
