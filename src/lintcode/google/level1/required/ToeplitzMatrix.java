package lintcode.google.level1.required;

/**
 * Description
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * <p>
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 * <p>
 * matrix will be a 2D array of integers.
 * matrix will have a number of rows and columns in range [1, 20].
 * matrix[i][j] will be integers in range [0, 99].
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * Output: True
 * Explanation:
 * 1234
 * 5123
 * 9512
 * <p>
 * In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", and in each diagonal all elements are the same, so the answer is True.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: matrix = [[1,2],[2,2]]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 */

public class ToeplitzMatrix {
    /**
     * @param matrix: the given matrix
     * @return True if and only if the matrix is Toeplitz
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null) {
            return true;
        }
        int rLen = matrix.length;
        if (rLen == 0) {
            return true;
        }
        int cLen = matrix[0].length;
        if (cLen <= 1) {
            return true;
        }
        for (int i = 0; i < rLen - 1; i++) {
            int[] base = matrix[i];
            for (int j = i + 1; j < rLen; j++) {
                int[] compare = matrix[j];
                if (!isSame(base, compare, j - i)) {
                    return false;
                }
            }
        }


        return true;
    }

    private boolean isSame(int[] base, int[] compare, int start) {

        int compareLen = compare.length;

        for (int i = start; i < compareLen; i++) {
            if (base[i - start] != compare[i]) {
                return false;
            }
        }
        return true;
    }


}
