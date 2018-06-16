package lintcode.google.level2;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class LongestAbsoluteFilePathTest {
    @Test
    public void testlengthLongestPath() {
        LongestAbsoluteFilePath s = new LongestAbsoluteFilePath();

        String input;
        int expect;
        int output;
        int seq = 0;


        input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        expect = 20;
        output = s.lengthLongestPath(input);
        verify(expect, output, seq++);


        input = "dir";
        expect = 0;
        output = s.lengthLongestPath(input);
        verify(expect, output, seq++);


        input = "";
        expect = 0;
        output = s.lengthLongestPath(input);
        verify(expect, output, seq++);



        input = null;
        expect = 0;
        output = s.lengthLongestPath(input);
        verify(expect, output, seq++);
    }

}
