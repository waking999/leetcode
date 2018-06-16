package leetcode.attempt;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class ContainsDuplicateIIITest {
    @Test
    public void testcontainsNearbyAlmostDuplicate() {
        ContainsDuplicateIII s = new ContainsDuplicateIII();

        int[] nums;
        int k;
        int t;
        boolean expect;
        boolean output;
        int seq = 0;


        nums = new int[]{1, 2, 3, 1};
        k = 3;
        t = 0;
        expect = true;
        output = s.containsNearbyAlmostDuplicate(nums, k, t);
        verify(expect, output, seq++);

        nums = new int[]{1, 0, 1, 1};
        k = 1;
        t = 2;
        expect = true;
        output = s.containsNearbyAlmostDuplicate(nums, k, t);
        verify(expect, output, seq++);

        nums = new int[]{1, 5, 9, 1, 5, 9};
        k = 2;
        t = 3;
        expect = false;
        output = s.containsNearbyAlmostDuplicate(nums, k, t);
        verify(expect, output, seq++);

        nums = new int[]{-2147483648, -2147483647};
        k = 3;
        t = 3;
        expect = true;
        output = s.containsNearbyAlmostDuplicate(nums, k, t);
        verify(expect, output, seq++);


    }
}
