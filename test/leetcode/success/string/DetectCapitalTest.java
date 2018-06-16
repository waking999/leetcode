package leetcode.success.string;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class DetectCapitalTest {
    @Test
    public void test1() {
        DetectCapital s = new DetectCapital();

        String word;
        boolean expect;
        boolean output;

        word = "USA";
        expect = true;
        output = s.detectCapitalUse(word);
        verify(expect, output, 1);

        word = "leetcode";
        expect = true;
        output = s.detectCapitalUse(word);
        verify(expect, output, 2);

        word = "Google";
        expect = true;
        output = s.detectCapitalUse(word);
        verify(expect, output, 3);

        word = "FlaG";
        expect = false;
        output = s.detectCapitalUse(word);
        verify(expect, output, 4);


        word = "FFFFFFFFFFFFFFFFFFFFf";
        expect = false;
        output = s.detectCapitalUse(word);
        verify(expect, output, 4);

        System.out.println("Finish");


    }

}
