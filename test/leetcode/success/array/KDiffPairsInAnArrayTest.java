package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

public class KDiffPairsInAnArrayTest {

    @Test
    public void test1() {
        KDiffPairsInAnArray s = new KDiffPairsInAnArray();

        int[] nums;
        int k;
        int expect;
        int output;
        int seq = 1;

        nums = new int[]{3, 1, 4, 1, 5};
        k = 2;
        expect = 2;
        output = s.findPairs(nums, k);
        Util.verify(expect, output, seq++);

        nums = new int[]{1, 2, 3, 4, 5};
        k = 1;
        expect = 4;
        output = s.findPairs(nums, k);
        Util.verify(expect, output, seq++);

        nums = new int[]{1, 3, 1, 5, 4};
        k = 0;
        expect = 1;
        output = s.findPairs(nums, k);
        Util.verify(expect, output, seq++);

    }
}
