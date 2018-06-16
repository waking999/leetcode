package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verifyUnsort;

public class SpiralMatrixIITest {
    @Test
    public void testspiralOrder() {
        SpiralMatrixII s = new SpiralMatrixII();
        int n;
        int[][] expect;
        int[][] output;
        int seq = 1;

        n = 3;
        expect = new int[][]{{1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}};

        output = s.generateMatrix(n);
        verifyUnsort(expect, output, seq++);


    }
}
