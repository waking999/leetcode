package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class SearchA2DMatrixTest {
    @Test
    public void test1() {
        SearchA2DMatrix s = new SearchA2DMatrix();

        int[][] matrix;
        int target;
        boolean expect;
        boolean output;
        int seq = 1;

        matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        target = 3;
        expect = true;
        output = s.searchMatrix(matrix, target);
        verify(expect, output, seq++);

    }
}
