package leetcode.attempt;

import common.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TopKFrequentElementsTest {
    @Test
    public void test1() {
        TopKFrequentElements s = new TopKFrequentElements();

        int[] nums;
        int k;
        int[] expect;
        List<Integer> output;
        int seq = 1;

        nums = new int[]{1, 1, 1, 2, 2, 3};
        k = 2;
        expect = new int[]{1, 2};
        output=s.topKFrequent(nums,k);
        Util.verifyUnsort(expect,output,seq++);
    }
}
