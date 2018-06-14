package leetcode.success.array;


public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[][]{{}};
        }
        int[][] matrix = new int[n][n];

        int rowLower = -1;
        int rowUpper = n;
        int colLower = -1;
        int colUpper = n;
        int i = 0;
        int j = 0;
        char dir = 'r';
        int k = 1;
        while (i > rowLower && i < rowUpper && j > colLower && j < colUpper) {
            matrix[i][j] = k;
            k++;
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

        return matrix;
    }


}
