package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class ArrayPartitionITest {
    @Test
    public void test1() {
        ArrayPartitionI s = new ArrayPartitionI();

        int[] nums;
        int expect;
        int output;

        nums = new int[]{1, 4, 3, 2};
        expect = 4;
        output = s.arrayPairSum(nums);
        verify(expect, output, 1);

    }
}
