package leetcode.success.combination;

import org.junit.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class PermutationsTest {
    @Test
    public void test1() {
        Permutations s = new Permutations();

        int[] nums;
        int[][] expect;
        List<List<Integer>> output;
        int seq = 1;

        nums = new int[]{1, 2, 3};
        expect = new int[][]{{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};

        output = s.permute(nums);
        verifyUnsort(expect, output, seq++);

    }
}
