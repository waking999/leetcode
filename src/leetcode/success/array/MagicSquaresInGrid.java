package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

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
                    expectSum += squareArray[k];
                }
                if (isMagic(squareArray, expectSum)) {
                    count++;
                }

            }
        }

        return count;
    }

    private boolean isMagic(int[] squareArray, int expectSum) {
        int squareArrayLen = squareArray.length;
        if (squareArrayLen != SQUARE_SIZE) {
            return false;
        }
        int[] exists = new int[SQUARE_SIZE];
        Arrays.fill(exists, 0);

        //1-9
        for (int i = 0; i < SQUARE_SIZE; i++) {
            int num = squareArray[i];
            if(num>9||num<1){
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

        //col
        for (int i = 0; i < SQUARE_WIDTH; i++) {
            int colSum = 0;
            for (int j = 0; j < SQUARE_WIDTH; j++) {
                int idx = i + j * SQUARE_WIDTH;
                colSum += squareArray[idx];
            }
        }

        //diagonals
        int sumDiagonal1 = squareArray[0] + squareArray[4] + squareArray[8];
        if (sumDiagonal1 != expectSum) {
            return false;
        }
        int sumDiagonal2 = squareArray[2] + squareArray[4] + squareArray[6];
        if (sumDiagonal1 != expectSum) {
            return false;
        }

        return true;
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

    @Test
    public void testIsMagic() {
        MagicSquaresInGrid s = new MagicSquaresInGrid();
        int[] square;
        int seq=0;
        boolean expect;
        boolean output;

        square = new int[]{4, 3, 8, 9, 5, 1, 2, 7, 6};
        expect=true;
        output=s.isMagic(square,15);
        Util.verify(expect,output,seq++);

        square = new int[]{ 3, 8,4,  5, 1,9, 7, 6,2};
        expect=false;
        output=s.isMagic(square,15);
        Util.verify(expect,output,seq++);

    }
    @Test
    public void testNumMagicSquaresInside() {
        MagicSquaresInGrid s = new MagicSquaresInGrid();
        int[][] grid;


        int expect;
        int output;
        int seq = 0;


        grid = new int[][]{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}};
        expect = 1;
        output = s.numMagicSquaresInside(grid);
        Util.verify(expect, output, seq++);


        grid = new int[][]{{10,3,5},{1,6,11},{7,9,2}};
        expect=0;
        output = s.numMagicSquaresInside(grid);
        Util.verify(expect, output, seq++);


        grid = new int[][]{{7,0,5},{2,4,6},{3,8,1}};
        expect=0;
        output = s.numMagicSquaresInside(grid);
        Util.verify(expect, output, seq++);
    }
}
