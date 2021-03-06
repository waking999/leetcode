package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class NondecreasingArrayTest {
    @Test
    public void test1() {
        NondecreasingArray s = new NondecreasingArray();

        int[] nums;
        boolean expect;
        boolean output;

        nums = new int[]{4, 2, 3};
        expect = true;
        output = s.checkPossibility(nums);
        verify(expect, output, 1);

        nums = new int[]{4, 2, 1};
        expect = false;
        output = s.checkPossibility(nums);
        verify(expect, output, 2);

        nums = new int[]{3, 4, 2, 3};
        expect = false;
        output = s.checkPossibility(nums);
        verify(expect, output, 3);


    }
}
