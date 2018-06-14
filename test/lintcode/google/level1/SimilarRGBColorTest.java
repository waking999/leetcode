package lintcode.google.level1;

import leetcode.success.comm.Util;
import org.junit.Test;

import static leetcode.success.comm.Util.*;

public class SimilarRGBColorTest {
    @Test
    public void testsimilarRGB() {
        SimilarRGBColor s = new SimilarRGBColor();

        String color;
        String expect;
        String output;
        int seq = 0;

        color=  "#09f166";
        expect= "#11ee66";
        output=s.similarRGB(color);
        verify(expect,output,seq++);

        color = "#1c9e03";
        expect = "#229900";
        output = s.similarRGB(color);
        verify(expect, output, seq++);


    }
}
