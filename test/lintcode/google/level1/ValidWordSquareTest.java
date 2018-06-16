package lintcode.google.level1;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class ValidWordSquareTest {
    @Test
    public void testValidWordSquare() {
        ValidWordSquare s = new ValidWordSquare();

        String[] words;
        boolean expect;
        boolean output;
        int seq = 0;


        words = new String[]{"abcd", "bnrt", "crmy", "dtye"};
        expect = true;
        output = s.validWordSquare(words);
        verify(expect, output, seq++);

        words = new String[]{"abcd", "bnrt", "crm", "dt"};
        expect = true;
        output = s.validWordSquare(words);
        verify(expect, output, seq++);


        words = new String[]{"ball", "area", "read", "lady"};
        expect = false;
        output = s.validWordSquare(words);
        verify(expect, output, seq++);

        words = new String[]{};
        expect = true;
        output = s.validWordSquare(words);
        verify(expect, output, seq++);

        words = null;
        expect = true;
        output = s.validWordSquare(words);
        verify(expect, output, seq++);

    }
}
