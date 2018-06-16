package leetcode.pending;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class CombinationsTest {
    @Test
    public void test1() {
        Combinations s = new Combinations();

        int n;
        int k;
        int[][] expect;

        List<List<Integer>> output;
        int seq = 1;

        n = 4;
        k = 2;
        expect = new int[][]{{1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}};

        output = s.combine(n, k);
        verifyUnsort(expect, output, seq++);


    }
}
