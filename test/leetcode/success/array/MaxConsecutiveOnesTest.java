package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

public class MaxConsecutiveOnesTest {
    @Test
    public void test1() {
        MaxConsecutiveOnes s = new MaxConsecutiveOnes();

        int[] nums;
        int expect;
        int output;

        nums = new int[] { 1, 1, 0, 1, 1, 1 };
        expect = 3;
        output = s.findMaxConsecutiveOnes(nums);
        Util.verify(expect,output,1);
    }

}
