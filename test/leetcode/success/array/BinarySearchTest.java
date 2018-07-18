package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {
    @Test
    public void test1() {
        BinarySearch s = new BinarySearch();

        int[] nums;
        int target;
        int expect;
        int output;
        int seq = 1;

        nums = new int[]{-1, 0, 3, 5, 9, 12};
        target = 9;
        expect = 4;
        output = s.search(nums, target);
        Util.verify(expect, output, seq++);

        nums = new int[]{-1, 0, 3, 5, 9, 12};
        target = 2;
        expect = -1;
        output = s.search(nums, target);
        Util.verify(expect, output, seq++);
    }
}
