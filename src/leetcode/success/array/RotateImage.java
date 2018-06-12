package leetcode.success.array;


import leetcode.success.comm.Util;
import org.junit.Test;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int rLen = matrix.length;
        if (rLen < 2) {
            return;
        }

        int[] array = convertMartixToArray(matrix);
        int k = 0;
        for (int j = rLen - 1; j >= 0; j--) {
            for (int i = 0; i < rLen; i++) {
                matrix[i][j] = array[k];
                k++;
            }
        }

    }

    private int[] convertMartixToArray(int[][] matrix) {
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        int len = rLen * cLen;
        int[] rtn = new int[len];
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                int idx = i * rLen + j;
                rtn[idx] = matrix[i][j];
            }
        }
        return rtn;
    }

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
        Util.verifyUnsort(expect, matrix, seq++);


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
        Util.verifyUnsort(expect, matrix, seq++);


    }
}
