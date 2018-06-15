package leetcode.success.array;

import org.junit.Test;

import static common.Util.verify;

public class MagicSquaresInGridTest {
    @Test
    public void testIsMagic() {
        MagicSquaresInGrid s = new MagicSquaresInGrid();
        int[] square;
        int seq = 0;
        boolean expect;
        boolean output;

        square = new int[]{4, 3, 8, 9, 5, 1, 2, 7, 6};
        expect = true;
        output = s.isMagic(square, 15);
        verify(expect, output, seq++);

        square = new int[]{3, 8, 4, 5, 1, 9, 7, 6, 2};
        expect = false;
        output = s.isMagic(square, 15);
        verify(expect, output, seq++);

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
        verify(expect, output, seq++);


        grid = new int[][]{{10, 3, 5}, {1, 6, 11}, {7, 9, 2}};
        expect = 0;
        output = s.numMagicSquaresInside(grid);
        verify(expect, output, seq++);


        grid = new int[][]{{7, 0, 5}, {2, 4, 6}, {3, 8, 1}};
        expect = 0;
        output = s.numMagicSquaresInside(grid);
        verify(expect, output, seq++);
    }
}
