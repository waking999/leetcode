package leetcode.success.array;

import java.util.Arrays;

public class MagicSquaresInGrid {
    private final static int SQUARE_WIDTH = 3;
    private final static int SQUARE_SIZE = SQUARE_WIDTH * SQUARE_WIDTH;

    public int numMagicSquaresInside(int[][] grid) {
        int rowLen = grid.length;
        if (rowLen < SQUARE_WIDTH) {
            return 0;
        }
        int colLen = grid[0].length;
        if (colLen < SQUARE_WIDTH) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i <= rowLen - SQUARE_WIDTH; i++) {
            for (int j = 0; j <= colLen - SQUARE_WIDTH; j++) {
                int[] squareArray = getSubSqaure(grid, i, j);
                int expectSum = 0;
                for (int k = 0; k < SQUARE_WIDTH; k++) {
                    assert squareArray != null;
                    expectSum += squareArray[k];
                }
                if (isMagic(squareArray, expectSum)) {
                    count++;
                }

            }
        }

        return count;
    }

    boolean isMagic(int[] squareArray, int expectSum) {
        int squareArrayLen = squareArray.length;
        if (squareArrayLen != SQUARE_SIZE) {
            return false;
        }
        int[] exists = new int[SQUARE_SIZE];
        Arrays.fill(exists, 0);

        //1-9
        for (int i = 0; i < SQUARE_SIZE; i++) {
            int num = squareArray[i];
            if (num > 9 || num < 1) {
                return false;
            }
            if (exists[num - 1] == 0) {
                exists[num - 1]++;
            } else {
                return false;
            }
        }

        //row
        for (int i = 1; i < SQUARE_WIDTH; i++) {
            int rowSum = 0;
            for (int j = 0; j < SQUARE_WIDTH; j++) {
                int idx = i * SQUARE_WIDTH + j;
                rowSum += squareArray[idx];
            }
            if (rowSum != expectSum) {
                return false;
            }
        }


        //diagonals
        int sumDiagonal1 = squareArray[0] + squareArray[4] + squareArray[8];
        return sumDiagonal1 == expectSum;
    }

    private int[] getSubSqaure(int[][] grid, int startI, int startJ) {
        int rowLen = grid.length;
        if (rowLen < SQUARE_WIDTH) {
            return null;
        }
        int colLen = grid[0].length;
        if (colLen < SQUARE_WIDTH) {
            return null;
        }
        if (rowLen - startI < SQUARE_WIDTH) {
            return null;
        }
        if (colLen - startJ < SQUARE_WIDTH) {
            return null;
        }

        int[] rtn = new int[SQUARE_SIZE];

        for (int i = 0; i < SQUARE_WIDTH; i++) {
            for (int j = 0; j < SQUARE_WIDTH; j++) {
                int rtnIdx = i * SQUARE_WIDTH + j;
                rtn[rtnIdx] = grid[startI + i][startJ + j];
            }
        }

        return rtn;
    }


}
