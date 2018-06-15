package leetcode.success.combination;

import org.junit.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class CombinationSumTest {
    @Test
    public void test1() {
        CombinationSum s = new CombinationSum();

        int[] candidates;
        int target;
        int[][] expect;

        List<List<Integer>> output;
        int seq = 1;

        candidates = new int[]{2, 3, 6, 7};
        target = 7;
        expect = new int[][]{{2, 2, 3}, {7}};

        output = s.combinationSum(candidates, target);
        verifyUnsort(expect, output, seq++);

    }
}
