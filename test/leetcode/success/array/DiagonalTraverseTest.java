package leetcode.attempt;

import common.Util;
import org.junit.jupiter.api.Test;

public class DiagonalTraverseTest {
    @Test
    public void test1() {
        DiagonalTraverse s = new DiagonalTraverse();

        int[][] matrix;
        int[] expect;
        int[] output;
        int seq = 1;

        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        expect = new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9};
        output = s.findDiagonalOrder(matrix);
        Util.verifyUnsort(expect, output, seq++);

        matrix = new int[][]{{1, 2, 3, 1, 4}, {4, 5, 6, 2, 5}, {7, 8, 9, 3, 6}};
        expect = new int[]{1, 2, 4, 7, 5, 3, 1, 6, 8, 9, 2, 4, 5, 3, 6};
        output = s.findDiagonalOrder(matrix);
        Util.verifyUnsort(expect, output, seq++);

        matrix = new int[][]{{1, 2, 3, 1, 4, 7}, {4, 5, 6, 2, 5, 8}, {7, 8, 9, 3, 6, 9}};
        expect = new int[]{1, 2, 4, 7, 5, 3, 1, 6, 8, 9, 2, 4, 7, 5, 3, 6, 8, 9};
        output = s.findDiagonalOrder(matrix);
        Util.verifyUnsort(expect, output, seq++);

        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 2, 3}, {4, 5, 6}};
        expect = new int[]{1, 2, 4, 7, 5, 3, 6, 8, 1, 4, 2, 9, 3, 5, 6};
        output = s.findDiagonalOrder(matrix);
        Util.verifyUnsort(expect, output, seq++);

        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        expect = new int[]{1, 2, 4, 7, 5, 3, 6, 8, 1, 4, 2, 9, 3, 5, 7, 8, 6, 9};
        output = s.findDiagonalOrder(matrix);
        Util.verifyUnsort(expect, output, seq++);

        matrix = new int[][]{};
        expect = new int[]{};
        output = s.findDiagonalOrder(matrix);
        Util.verifyUnsort(expect, output, seq++);

        matrix = new int[][]{{}};
        expect = new int[]{};
        output = s.findDiagonalOrder(matrix);
        Util.verifyUnsort(expect, output, seq++);


        matrix = new int[][]{{ 1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        expect = new int[]{1,2,5,9,6,3,4,7,10,13,14,11,8,12,15,16};
        output = s.findDiagonalOrder(matrix);
        Util.verifyUnsort(expect, output, seq++);
    }
}
