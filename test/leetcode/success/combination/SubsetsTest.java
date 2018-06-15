package leetcode.success.combination;

import org.junit.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class SubsetsTest {
    @Test
    public void test1() {
        Subsets s = new Subsets();

        int[] nums;
        int[][] expect;

        List<List<Integer>> output;
        int seq = 1;

        nums = new int[]{1, 2, 3};
        expect = new int[][]{{}, {1}, {1, 2}, {1, 2, 3}, {1, 3}, {2}, {2, 3}, {3}};

        output = s.subsets(nums);
        verifyUnsort(expect, output, seq++);

    }
}
