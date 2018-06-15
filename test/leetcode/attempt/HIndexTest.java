package leetcode.attempt;

import org.junit.Test;

import static common.Util.verify;

public class HIndexTest {
    @Test
    public void test1() {
        HIndex s = new HIndex();

        int[] citations;
        int expect;
        int output;
        int seq = 0;

        citations = new int[]{3, 0, 6, 1, 5};
        expect = 3;
        output = s.hIndex(citations);
        verify(expect, output, ++seq);

        citations = new int[]{100};
        expect = 1;
        output = s.hIndex(citations);
        verify(expect, output, ++seq);

        citations = new int[]{0};
        expect = 0;
        output = s.hIndex(citations);
        verify(expect, output, ++seq);

        citations = new int[]{0, 1};
        expect = 1;
        output = s.hIndex(citations);
        verify(expect, output, ++seq);

        citations = new int[]{1, 1};
        expect = 1;
        output = s.hIndex(citations);
        verify(expect, output, ++seq);

        citations = new int[]{11, 15};
        expect = 2;
        output = s.hIndex(citations);
        verify(expect, output, ++seq);
    }
}
