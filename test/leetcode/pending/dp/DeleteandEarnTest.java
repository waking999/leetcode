
package leetcode.pending.dp;

import common.Util;
import leetcode.pending.dp.DeleteandEarn;
import org.junit.jupiter.api.Test;

public class DeleteandEarnTest {
    @Test
    public void test1() {
        DeleteandEarn s = new DeleteandEarn();

        int[] nums;
        int expect;
        int output;
        int seq = 1;


//        nums = new int[]{3, 4, 2};
//        expect = 6;
//        output = s.deleteAndEarn(nums);
//        Util.verify(expect, output, seq++);
//
//        nums = new int[]{2, 2, 3, 3, 3, 4};
//        expect = 9;
//        output = s.deleteAndEarn(nums);
//        Util.verify(expect, output, seq++);


        nums = new int[]{8,10,4,9,1,3,5,9,4,10};
        expect = 9;
        output = s.deleteAndEarn(nums);
        Util.verify(expect, output, seq++);
    }
}
