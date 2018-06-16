package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verifyUnsort;

public class ReshapetheMatrixTest {
    @Test
    public void test1() {
        ReshapetheMatrix s = new ReshapetheMatrix();

        int[][] nums;
        int r;
        int c;
        int[][] expect;
        int[][] output;

        nums = new int[][]{{1, 2}, {3, 4}};
        r = 1;
        c = 4;
        expect = new int[][]{{1, 2, 3, 4}};
        output = s.matrixReshape(nums, r, c);
        verifyUnsort(expect, output, 1);

        nums = new int[][]{{1, 2}, {3, 4}};
        r = 2;
        c = 4;
        expect = new int[][]{{1, 2}, {3, 4}};
        output = s.matrixReshape(nums, r, c);
        verifyUnsort(expect, output, 2);
    }
}
