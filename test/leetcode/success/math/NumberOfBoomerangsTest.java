package leetcode.success.math;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class NumberOfBoomerangsTest {
    @Test
    public void test1() {
        NumberOfBoomerangs s = new NumberOfBoomerangs();

        int[][] points;
        int expect;
        int output;

        points = new int[][]{{0, 0}, {1, 0}, {2, 0}};
        expect = 2;
        output = s.numberOfBoomerangs(points);
        verify(expect, output, 1);

        System.out.println("Finish");

    }
}
