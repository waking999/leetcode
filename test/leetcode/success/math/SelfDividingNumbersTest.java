package leetcode.success.math;

import org.junit.Test;

import java.util.List;

import static common.Util.verifySort;

public class SelfDividingNumbersTest {
    @Test
    public void test1() {
        SelfDividingNumbers s = new SelfDividingNumbers();

        int left;
        int right;
        int[] expect;
        List<Integer> output;
        int seq = 1;

        left = 1;
        right = 22;
        expect = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22};
        output = s.selfDividingNumbers(left, right);
        verifySort(expect, output, seq++);
    }

}
