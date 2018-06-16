package leetcode.success.tree;

import org.junit.jupiter.api.Test;

import static common.Util.verifyUnsort;

public class FloodFillTest {
    @Test
    public void test1() {

        FloodFill s = new FloodFill();
        int[][] image;
        int sr;
        int sc;
        int newColor;
        int[][] expect;
        int[][] output;
        int seq = 0;

        image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        sr = 1;
        sc = 1;
        newColor = 2;
        expect = new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}};
        output = s.floodFill(image, sr, sc, newColor);
        verifyUnsort(expect, output, seq++);
    }
}
