package leetcode.pending;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class RangeAdditionIITest {

    @Test
    public void test1() {
        RangeAdditionII s = new RangeAdditionII();

        int m;
        int n;
        int[][] ops;
        int expect;
        int output;

        m = 3;
        n = 3;
        ops = new int[][]{{2, 2}, {3, 3}};
        expect = 4;
        output = s.maxCount(m, n, ops);
        verify(expect, output, 1);


        m = 3;
        n = 3;
        ops = new int[][]{};
        expect = 9;
        output = s.maxCount(m, n, ops);
        verify(expect, output, 1);

    }
}
