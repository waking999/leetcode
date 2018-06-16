package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class DegreeofanArrayTest {


    @Test
    public void test1() {
        DegreeofanArray s = new DegreeofanArray();

        int[] nums;
        int expect;
        int output;
        int seq = 0;

        nums = new int[]{1, 2, 2, 3, 1};
        expect = 2;
        output = s.findShortestSubArray(nums);
        verify(expect, output, ++seq);

        nums = new int[]{1, 2, 2, 3, 1, 4, 2};
        expect = 6;
        output = s.findShortestSubArray(nums);
        verify(expect, output, ++seq);

        nums = new int[]{1};
        expect = 1;
        output = s.findShortestSubArray(nums);
        verify(expect, output, ++seq);

        nums = new int[]{3, 3, 4};
        expect = 2;
        output = s.findShortestSubArray(nums);
        verify(expect, output, ++seq);
    }
}
