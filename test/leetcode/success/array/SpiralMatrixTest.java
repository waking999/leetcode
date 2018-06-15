package leetcode.success.array;


import org.junit.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class SpiralMatrixTest {
    @Test
    public void testspiralOrder() {
        SpiralMatrix s = new SpiralMatrix();
        int[][] matrix;
        int[] expect;
        List<Integer> output;
        int seq = 0;

        matrix = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        expect = new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5};
        output = s.spiralOrder(matrix);
        verifyUnsort(expect, output, seq);

        matrix = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        expect = new int[]{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7};
        output = s.spiralOrder(matrix);
        verifyUnsort(expect, output, seq);

        matrix = new int[][]{{}};
        expect = new int[]{};
        output = s.spiralOrder(matrix);
        verifyUnsort(expect, output, seq);

    }
}
