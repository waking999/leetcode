package leetcode.success.math;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class IslandPerimeterTest {
    @Test
    public void test1() {
        IslandPerimeter s = new IslandPerimeter();

        int[][] grid;
        int expect;
        int output;
        int seq = 1;

        grid = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        expect = 16;
        output = s.islandPerimeter(grid);
        verify(expect, output, seq++);


        grid = new int[][]{{1}};
        expect = 4;
        output = s.islandPerimeter(grid);
        verify(expect, output, seq++);
    }
}
