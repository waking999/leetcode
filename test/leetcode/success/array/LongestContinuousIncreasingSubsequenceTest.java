package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

public class LongestContinuousIncreasingSubsequenceTest {
    @Test
    public void test1() {
        LongestContinuousIncreasingSubsequence s=new LongestContinuousIncreasingSubsequence();

        int[] nums;
        int expect;
        int output;
int seq=1;

        nums=new int[] {1,3,5,4,7};
        expect=3;
        output=s.findLengthOfLCIS(nums);
        Util.verify(expect, output, seq++);

        nums=new int[] {2,2,2,2};
        expect=1;
        output=s.findLengthOfLCIS(nums);
        Util.verify(expect, output, seq++);

    }

}
