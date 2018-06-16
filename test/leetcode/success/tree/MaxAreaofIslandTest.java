package leetcode.success.tree;

import static common.Util.verify;

public class MaxAreaofIslandTest {
    public static void main(String[] args) {
        MaxAreaofIsland s = new MaxAreaofIsland();

        int[][] grid;
        int expect;
        int output;
        int seq = 0;

        grid = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        expect = 6;
        output = s.maxAreaOfIsland(grid);
        verify(expect, output, seq++);

        grid = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}};
        expect = 0;
        output = s.maxAreaOfIsland(grid);
        verify(expect, output, seq++);

    }

}
