package leetcode.attempt;

import common.Util;
import org.junit.jupiter.api.Test;

public class SingleElementinaSortedArrayTest {
    @Test
    public void test1() {
        SingleElementinaSortedArray s = new SingleElementinaSortedArray();

        int[] nums;
        int expect;
        int output;
        int seq = 1;

        nums = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        expect = 2;
        output = s.singleNonDuplicate(nums);
        Util.verify(expect, output, seq++);

        nums = new int[]{3, 3, 7, 7, 10, 11, 11};
        expect = 10;
        output = s.singleNonDuplicate(nums);
        Util.verify(expect, output, seq++);

    }
}
