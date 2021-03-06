package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verifyUnsort;

public class NumberofLinesToWriteStringTest {
    @Test
    public void testNumberOfLines() {
        NumberofLinesToWriteString s = new NumberofLinesToWriteString();
        int[] widths;
        String S;
        int[] expect;
        int[] output;
        int seq = 0;

        widths = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        S = "abcdefghijklmnopqrstuvwxyz";
        expect = new int[]{3, 60};
        output = s.numberOfLines(widths, S);
        verifyUnsort(expect, output, seq++);


        widths = new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        S = "bbbcccdddaaa";
        expect = new int[]{2, 4};
        output = s.numberOfLines(widths, S);
        verifyUnsort(expect, output, seq++);

    }
}
