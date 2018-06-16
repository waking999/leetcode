package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verifyUnsort;

public class RelativeRanksTest {
    @Test
    public void test1() {
        RelativeRanks s = new RelativeRanks();

        int[] nums;
        String[] expect;
        String[] output;

        nums = new int[]{5, 4, 3, 2, 1};
        expect = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"};
        output = s.findRelativeRanks(nums);
        verifyUnsort(expect, output, 1);


        nums = new int[]{1, 4, 5, 3, 2};
        expect = new String[]{"5", "Silver Medal", "Gold Medal", "Bronze Medal", "4"};
        output = s.findRelativeRanks(nums);
        verifyUnsort(expect, output, 1);

    }
}
