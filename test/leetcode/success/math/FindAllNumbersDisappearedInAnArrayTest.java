package leetcode.success.math;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.Util.verifySort;

public class FindAllNumbersDisappearedInAnArrayTest {
    @Test
    public void test1() {
        FindAllNumbersDisappearedInAnArray s = new FindAllNumbersDisappearedInAnArray();

        int[] nums;
        int[] expect;
        List<Integer> output;

        nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        expect = new int[]{5, 6};
        output = s.findDisappearedNumbers(nums);
        verifySort(expect, output, 1);


    }
}
