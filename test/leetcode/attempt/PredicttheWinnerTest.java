package leetcode.attempt;

import common.Util;
import org.junit.Test;

import static common.Util.*;

public class PredicttheWinnerTest {
    @Test
    public void test1() {
        PredicttheWinner s = new PredicttheWinner();

        int[] nums;
        boolean expect;
        boolean output;

        nums = new int[]{1, 5, 2};
        expect = false;
        output = s.PredictTheWinner(nums);
        verify(expect, output, 1);


        nums = new int[]{1, 5, 233, 7};
        expect = true;
        output = s.PredictTheWinner(nums);
        verify(expect, output, 2);


    }
}
