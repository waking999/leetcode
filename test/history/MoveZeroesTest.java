package history;

import org.junit.Test;

import static common.Util.verifyUnsort;

public class MoveZeroesTest {
    @Test
    public void test1() {
        MoveZeroes a = new MoveZeroes();
        int[] nums;
        int[] expect;
        int seq = 1;

        nums = new int[]{0, 1, 0, 3, 12};
        expect = new int[]{1, 3, 12, 0, 0};
        a.moveZeroes(nums);
        verifyUnsort(expect, nums, seq++);


        nums = new int[]{0, 0, 1};
        expect = new int[]{1, 0, 0};
        a.moveZeroes(nums);
        verifyUnsort(expect, nums, seq++);


    }
}
