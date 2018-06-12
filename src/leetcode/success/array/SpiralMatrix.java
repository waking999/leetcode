package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rtn = new ArrayList<>();
        if(matrix==null){
            return rtn;
        }
        int rowLen = matrix.length;
        if(rowLen==0){
            return rtn;
        }
        int colLen=matrix[0].length;



        int rowLower = -1;
        int rowUpper = rowLen;
        int colLower = -1;
        int colUpper = colLen;
        int i = 0;
        int j = 0;
        char dir = 'r';
        while (i > rowLower && i < rowUpper && j > colLower && j < colUpper) {
            rtn.add(matrix[i][j]);
            if (dir == 'r') {
                j++;
                if (j == colUpper) {
                    j--;
                    dir = 'd';
                    i++;
                    rowLower++;
                }
            } else if (dir == 'd') {
                i++;
                if (i == rowUpper) {
                    i--;
                    dir = 'l';
                    j--;
                    colUpper--;
                }

            } else if (dir == 'l') {
                j--;
                if (j == colLower) {
                    j++;
                    dir = 'u';
                    i--;
                    rowUpper--;
                }

            } else if (dir == 'u') {
                i--;
                if (i == rowLower) {
                    i++;
                    dir = 'r';
                    j++;
                    colLower++;
                }
            }
        }
        return rtn;

    }


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
        Util.verifyUnsort(expect, output, seq);

        matrix = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        expect = new int[]{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7};
        output = s.spiralOrder(matrix);
        Util.verifyUnsort(expect, output, seq);

        matrix = new int[][]{{ } };
        expect = new int[]{ };
        output = s.spiralOrder(matrix);
        Util.verifyUnsort(expect, output, seq);

    }
}
