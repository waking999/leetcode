package lintcode.google.level1.required;

import org.junit.jupiter.api.Test;

import static common.Util.verifyUnsort;

public class PluseOneTest {
    @Test
    public void test1() {
        PluseOne s = new PluseOne();

        int seq = 1;

        int[] nums = {1, 9, 9};
        int[] expect = {2, 0, 0};
        int[] output = s.plusOne(nums);
        verifyUnsort(expect, output, seq++);

        nums = new int[]{1, 9, 8};
        expect = new int[]{1, 9, 9};
        output = s.plusOne(nums);
        verifyUnsort(expect, output, seq++);

        nums = new int[]{1, 9};
        expect = new int[]{2, 0};
        output = s.plusOne(nums);
        verifyUnsort(expect, output, seq++);

        nums = new int[]{9, 9, 9};
        expect = new int[]{1, 0, 0, 0};
        output = s.plusOne(nums);
        verifyUnsort(expect, output, seq++);

        nums = new int[]{1, 8, 9};
        expect = new int[]{1, 9, 0};
        output = s.plusOne(nums);
        verifyUnsort(expect, output, seq++);


    }
}
