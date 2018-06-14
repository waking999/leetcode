package lintcode.google.level1;

import org.junit.Test;

import static common.Util.*;

public class ToeplitzMatrixTest {
    @Test
    public void testIsToeplitzMatrix() {
        ToeplitzMatrix s = new ToeplitzMatrix();

        int[][] matrix;
        boolean expect;
        boolean output;
        int seq = 0;

        matrix = new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}, {6, 9, 5, 1}};
        expect = true;
        output = s.isToeplitzMatrix(matrix);
        verify(expect, output, seq++);


        matrix = new int[][]{{1, 2}, {2, 2}};
        expect = false;
        output = s.isToeplitzMatrix(matrix);
        verify(expect, output, seq++);

    }
}
