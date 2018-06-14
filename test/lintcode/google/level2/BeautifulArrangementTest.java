package lintcode.google.level2;

import common.VerifyUtil;
import org.junit.Test;

import static common.VerifyUtil.*;

public class BeautifulArrangementTest {
    @Test
    public void testcountArrangement() {
        BeautifulArrangement s = new BeautifulArrangement();

        int N;
        int expect;
        int output;
        int seq = 1;

        N = 1;
        expect = 1;
        output = s.countArrangement(N);
        verify(expect, output, seq++);

        N = 2;
        expect = 2;
        output = s.countArrangement(N);
        verify(expect, output, seq++);

        N = 3;
        expect = 3;
        output = s.countArrangement(N);
        verify(expect, output, seq++);

        N = 4;
        expect = 8;
        output = s.countArrangement(N);
        verify(expect, output, seq++);

        N = 5;
        expect = 10;
        output = s.countArrangement(N);
        verify(expect, output, seq++);

        N = 6;
        expect = 36;
        output = s.countArrangement(N);
        verify(expect, output, seq++);
    }

}
