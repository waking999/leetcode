package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class ThirdMaximumNumberTest {
    @Test
    public void test1() {
        ThirdMaximumNumber s = new ThirdMaximumNumber();

        int[] nums;
        int expect;
        int output;

        nums = new int[]{3, 2, 1};
        expect = 1;
        output = s.thirdMax(nums);
        verify(expect, output, 1);

        nums = new int[]{1, 2};
        expect = 2;
        output = s.thirdMax(nums);
        verify(expect, output, 2);

        nums = new int[]{2, 2, 3, 1};
        expect = 1;
        output = s.thirdMax(nums);
        verify(expect, output, 3);


    }
}
