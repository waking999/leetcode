package leetcode.success.string;

import static common.Util.verify;

public class NumberOfSegmentsInAStringTest {
    public static void main(String[] args) {
        NumberOfSegmentsInAString s = new NumberOfSegmentsInAString();

        String str;
        int expect;
        int output;
        int seq = 1;

        str = "Hello, my name is John";
        expect = 5;
        output = s.countSegments(str);
        verify(expect, output, seq++);


        str = "";
        expect = 0;
        output = s.countSegments(str);
        verify(expect, output, seq++);

        str = ", , , ,        a, eaefa";
        expect = 6;
        output = s.countSegments(str);
        verify(expect, output, seq++);
    }
}
