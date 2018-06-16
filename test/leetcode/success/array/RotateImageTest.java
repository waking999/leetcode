package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verifyUnsort;

public class RotateImageTest {
    @Test
    public void testrotate() {
        RotateImage s = new RotateImage();

        int[][] matrix;
        int[][] expect;
        int seq = 0;

        matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        expect = new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        s.rotate(matrix);
        verifyUnsort(expect, matrix, seq++);


        matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        expect = new int[][]{
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        };
        s.rotate(matrix);
        verifyUnsort(expect, matrix, seq++);


    }
}
