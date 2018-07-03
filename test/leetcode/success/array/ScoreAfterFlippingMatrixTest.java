package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

public class ScoreAfterFlippingMatrixTest {
    @Test
    public void test1() {
        ScoreAfterFlippingMatrix s = new ScoreAfterFlippingMatrix();

        int[][] A;
        int expect;
        int output;
        int seq = 1;

        A = new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        expect = 39;
        output = s.matrixScore(A);
        Util.verify(expect, output, seq++);
    }
}
