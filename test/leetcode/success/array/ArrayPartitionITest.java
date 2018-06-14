package leetcode.success.array;

import common.Util;
import org.junit.Test;

public class ArrayPartitionITest {
    @Test
    public void test1() {
        ArrayPartitionI s=new ArrayPartitionI();

        int[] nums;
        int expect;
        int output;

        nums=new int[] {1,4,3,2};
        expect=4;
        output=s.arrayPairSum(nums);
        Util.verify(expect, output, 1);

    }
}
