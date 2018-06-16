package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class ContainsDuplicateIITest {
    @Test
    public void test1() {
        ContainsDuplicateII s = new ContainsDuplicateII();

        int[] nums;
        int k;
        boolean expect;
        boolean output;
        int seq = 1;

        nums = new int[]{1, 2, 3, 4, 1, 5};
        k = 4;
        expect = true;
        output = s.containsNearbyDuplicate(nums, k);
        verify(expect, output, seq++);

        nums = new int[]{1, 2, 3, 4, 1, 5};
        k = 2;
        expect = false;
        output = s.containsNearbyDuplicate(nums, k);
        verify(expect, output, seq++);

        nums = new int[]{1, 2, 3, 4, 6, 5};
        k = 4;
        expect = false;
        output = s.containsNearbyDuplicate(nums, k);
        verify(expect, output, seq++);

        nums = new int[]{1, 0, 1, 1};
        k = 1;
        expect = true;
        output = s.containsNearbyDuplicate(nums, k);
        verify(expect, output, seq++);

        nums = new int[]{1, 2, 1};
        k = 1;
        expect = false;
        output = s.containsNearbyDuplicate(nums, k);
        verify(expect, output, seq++);

    }
}
