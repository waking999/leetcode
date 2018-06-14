package leetcode.success.array;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return false;
        }
        if (target < matrix[0][0]) {
            return false;
        }
        if (target > matrix[row - 1][col - 1]) {
            return false;
        }
        int rowNum = 0;
        int colNum = col - 1;
        while (rowNum < row && colNum >= 0) {
            if (target < matrix[rowNum][colNum]) {
                colNum--;
            } else if (target > matrix[rowNum][colNum]) {
                rowNum++;
            } else {
                return true;
            }
        }


        return false;
    }


}
