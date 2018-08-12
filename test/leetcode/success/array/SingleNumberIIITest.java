package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

public class SingleNumberIIITest {
    @Test
    public void test1() {
        SingleNumberIII s = new SingleNumberIII();

        int[] nums;
        int[] expect;
        int[] output;
        int seq = 1;

        nums = new int[]{1, 2, 1, 3, 2, 5};
        expect = new int[]{3, 5};
        output=s.singleNumber(nums);
        Util.verifySort(expect,output,seq++);


    }
}
